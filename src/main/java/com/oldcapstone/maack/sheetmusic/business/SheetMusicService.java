package com.oldcapstone.maack.sheetmusic.business;

import com.oldcapstone.maack.infra.feign.ai.dto.MidiResponse;
import com.oldcapstone.maack.sheetmusic.implement.MidiAdapter;
import com.oldcapstone.maack.sheetmusic.implement.SheetMusicQueryAdapter;
import com.oldcapstone.maack.sheetmusic.persistence.SheetMusic;
import com.oldcapstone.maack.sheetmusic.presentation.dto.SheetMusicResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class SheetMusicService {
    private final SheetMusicQueryAdapter sheetMusicQueryAdapter;
    private final SheetMusicMapper sheetMusicMapper;
    private final MidiAdapter midiAdapter;


    public SheetMusicResponseDTO.MySheetMusicPreViewListDTO getMySheetMusicList(Long memberId, Integer page){
        Page<SheetMusic> sheetMusicPage = sheetMusicQueryAdapter.findByMember(memberId, page);
        return sheetMusicMapper.mySheetMusicPreViewListDTO(sheetMusicPage);
    }

    @Transactional
    public SheetMusicResponseDTO.UploadSheetMusic addSheetMusic(final MultipartFile file) {
        // 1. FastAPI Call -> Midi 파일 목록 얻기
        try {
            MidiResponse midiResponse = midiAdapter.convertPdfToMidi(file.getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }


        // 2. Midi 파일 리스트 to MusicXML 파일 리스트


        // 3. S3 & DB 저장

        return null;
    }
}
