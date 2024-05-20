package com.oldcapstone.maack.sheetmusic.presentation.dto;

import lombok.*;

import java.util.List;

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

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class MySheetMusicPreViewListDTO{
        List<MySheetMusicPreViewDTO> mySheetMusicList;
        Integer listSize;
        Integer totalPage;
        Long totalElements;
        Boolean isFirst;
        Boolean isLast;
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class MySheetMusicPreViewDTO{
        Long sheetMusicId;
        List<PdfFileResponseDTO> pdfFileList;
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class PdfFileResponseDTO{
        Long pdfFileId;
        String fileName;
        String url;
        Long fileSize;
    }
}
