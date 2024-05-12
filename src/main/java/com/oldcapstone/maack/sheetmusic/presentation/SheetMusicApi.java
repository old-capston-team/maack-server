package com.oldcapstone.maack.sheetmusic.presentation;

import com.oldcapstone.maack.common.presentation.ApiResponse;
import com.oldcapstone.maack.sheetmusic.presentation.dto.SheetMusicResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RequestMapping("/api/v1/sheet-musics")
@RestController
@RequiredArgsConstructor
public class SheetMusicApi {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ApiResponse<SheetMusicResponseDTO.UploadSheetMusic> addSheetMusic(@RequestParam final MultipartFile file) {
        return null;
    }
}
