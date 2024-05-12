package com.oldcapstone.maack.sheetmusic.business;

import com.oldcapstone.maack.sheetmusic.presentation.dto.SheetMusicResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

@Service
@RequiredArgsConstructor
public class SheetMusicService {


    @Transactional
    public SheetMusicResponseDTO.UploadSheetMusic addSheetMusic(final MultipartFile file) {
        // 1. FastAPI Call -> Midi 파일 목록 얻기

        // 2. Midi 파일 리스트 to MusicXML 파일 리스트

        // 3. S3 & DB 저장

        return null;
    }
}
