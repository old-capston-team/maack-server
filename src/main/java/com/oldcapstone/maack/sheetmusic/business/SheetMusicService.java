package com.oldcapstone.maack.sheetmusic.business;

import com.oldcapstone.maack.common.property.S3BucketProperties;
import com.oldcapstone.maack.infra.aws.S3Uploader;
import com.oldcapstone.maack.infra.feign.ai.dto.MidiResponse;
import com.oldcapstone.maack.sheetmusic.implement.*;
import com.oldcapstone.maack.sheetmusic.persistence.MIDIFile;
import com.oldcapstone.maack.sheetmusic.persistence.MusicXMLFile;
import com.oldcapstone.maack.sheetmusic.persistence.PDFFile;
import com.oldcapstone.maack.sheetmusic.persistence.SheetMusic;
import com.oldcapstone.maack.sheetmusic.presentation.dto.SheetMusicResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import jakarta.xml.bind.JAXBException;
import javax.sound.midi.InvalidMidiDataException;
import java.io.IOException;

@Service
@RequiredArgsConstructor
public class SheetMusicService {

    private final SheetMusicQueryAdapter sheetMusicQueryAdapter;
    private final PDFFileQueryAdapter pdfFileQueryAdapter;
    private final MidiFileQueryAdapter midiFileQueryAdapter;
    private final MusicXMLFileQueryAdapter musicXMLFileQueryAdapter;

    private final SheetMusicMapper sheetMusicMapper;
    private final MidiAdapter midiAdapter;
    private final S3Uploader s3Uploader;

    private final PDFFileCommandAdapter pdfFileCommandAdapter;
    private final MIDIFileCommandAdapter midiFileCommandAdapter;
    private final MusicXMLFileCommandAdapter musicXMLFileCommandAdapter;
    private final SheetMusicCommandAdapter sheetMusicCommandAdapter;

    private final S3BucketProperties s3BucketProperties;

    private final MidiToMusicXMLConverter midiToMusicXMLConverter;

    public SheetMusicResponseDTO.MySheetMusicPreViewListDTO getMySheetMusicList(Long memberId, Integer page) {
        Page<SheetMusic> sheetMusicPage = sheetMusicQueryAdapter.findByMember(memberId, page);
        return sheetMusicMapper.mySheetMusicPreViewListDTO(sheetMusicPage);
    }

    public SheetMusicResponseDTO.SheetMusicViewResponseDTO getSheetMusic(Long sheetMusicId){
        SheetMusic sheetMusic = sheetMusicQueryAdapter.findById(sheetMusicId);
        PDFFile pdfFile = pdfFileQueryAdapter.findBySheetMusic(sheetMusicId);

        List<MIDIFile> midiFileList = pdfFile.getMidiFileList();
        List<MusicXMLFile> musicXMLFileList = new ArrayList<>();
        for(MIDIFile midiFile : midiFileList){
            MusicXMLFile musicXMLFile = musicXMLFileQueryAdapter.findByMidiFile(midiFile);
            musicXMLFileList.add(musicXMLFile);
        }

        return sheetMusicMapper.getSheetMusicDTO(sheetMusic, pdfFile, musicXMLFileList);
    }

    @Transactional
    public SheetMusicResponseDTO.UploadSheetMusic addSheetMusic(final MultipartFile file) {
        final String originFileName = file.getOriginalFilename();
        final Long pdfFileSize = file.getSize();

        try {
            // 1. SheetMusic 엔티티 생성 및 저장
            SheetMusic sheetMusic = SheetMusic.builder()
                    //.member(null) // 멤버 설정 필요
                    .build();
            sheetMusic = sheetMusicCommandAdapter.save(sheetMusic);

            // 2. PDF 파일을 S3에 업로드
            String pdfFileName = UUID.randomUUID().toString() + "_" + originFileName;
            String pdfUrl = s3Uploader.upload(file.getBytes(), s3BucketProperties.getBucket(), "pdf", pdfFileName);

            // 3. PDFFile 엔티티 생성 및 저장
            PDFFile pdfFile = PDFFile.builder()
                    .sheetMusic(sheetMusic)
                    .fileName(pdfFileName)
                    .url(pdfUrl)
                    .fileSize(pdfFileSize)
                    .build();
            pdfFile = pdfFileCommandAdapter.save(pdfFile);

            // 4. FastAPI 호출로 MIDI 파일 목록 얻기
            MidiResponse midiResponse = midiAdapter.convertPdfToMidi(file.getBytes());
            List<byte[]> midiFileByteList = midiResponse.getMidi();

            List<MIDIFile> midiFiles = new ArrayList<>();
            List<MusicXMLFile> musicXMLFiles = new ArrayList<>();

            // 5. 각 MIDI 파일 처리
            for (byte[] midiBytes : midiFileByteList) {
                // MIDI 파일을 S3에 업로드
                String midiFileName = UUID.randomUUID().toString() + ".midi";
                String midiUrl = s3Uploader.upload(midiBytes, s3BucketProperties.getBucket(), "midi", midiFileName);

                // MIDIFile 엔티티 생성 및 저장
                MIDIFile midiFile = MIDIFile.builder()
                        .pdfFile(pdfFile)
                        .fileName(midiFileName)
                        .url(midiUrl)
                        .fileSize((long) midiBytes.length)
                        .build();
                midiFile = midiFileCommandAdapter.save(midiFile);
                midiFiles.add(midiFile);

                // MIDI를 MusicXML로 변환 후 S3에 업로드
                byte[] musicXMLBytes = midiToMusicXMLConverter.convertMidiToMusicXML(midiBytes);
                String musicXMLFileName = UUID.randomUUID().toString() + ".musicxml";
                String musicXMLUrl = s3Uploader.upload(musicXMLBytes, s3BucketProperties.getBucket(), "musicxml", musicXMLFileName);

                // MusicXMLFile 엔티티 생성 및 저장
                MusicXMLFile musicXMLFile = MusicXMLFile.builder()
                        .midiFile(midiFile)
                        .fileName(musicXMLFileName)
                        .url(musicXMLUrl)
                        .fileSize((long) musicXMLBytes.length)
                        .build();
                musicXMLFile = musicXMLFileCommandAdapter.save(musicXMLFile);
                musicXMLFiles.add(musicXMLFile);
            }

            // Response DTO 반환
            return sheetMusicMapper.toUploadSheetMusic(sheetMusic, pdfFile);
        } catch (IOException | InvalidMidiDataException | JAXBException e) {
            throw new RuntimeException("악보 업로드 및 처리 실패", e);
        }
    }
}
