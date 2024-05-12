package com.oldcapstone.maack.sheetmusic.presentation.dto;

import lombok.*;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class SheetMusicResponseDTO {

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class UploadSheetMusic {
        private Long sheetMusicId;
        private String fileName;
        private String imageUrl;
        private Long fileSize;
    }
}
