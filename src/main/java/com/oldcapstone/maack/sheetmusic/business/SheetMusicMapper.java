package com.oldcapstone.maack.sheetmusic.business;

import com.oldcapstone.maack.common.annotation.Mapper;
import com.oldcapstone.maack.member.persistence.Member;
import com.oldcapstone.maack.sheetmusic.persistence.PDFFile;
import com.oldcapstone.maack.sheetmusic.persistence.SheetMusic;
import com.oldcapstone.maack.sheetmusic.presentation.dto.SheetMusicResponseDTO;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.stream.Collectors;

@Mapper
public class SheetMusicMapper {

    public static SheetMusicResponseDTO.PdfFileResponseDTO getPdfFileDTO(PDFFile pdfFile){
        return SheetMusicResponseDTO.PdfFileResponseDTO.builder()
                .pdfFileId(pdfFile.getId())
                .fileName(pdfFile.getFileName())
                .url(pdfFile.getUrl())
                .fileSize(pdfFile.getFileSize())
                .build();
    }

    public static SheetMusicResponseDTO.MySheetMusicPreViewDTO mySheetMusicPreViewDTO(SheetMusic sheetMusic){
        List<SheetMusicResponseDTO.PdfFileResponseDTO> pdfFileResponseDTOList = sheetMusic.getPdfFileList().stream()
                .map(SheetMusicMapper::getPdfFileDTO).collect(Collectors.toList());

        return SheetMusicResponseDTO.MySheetMusicPreViewDTO.builder()
                .sheetMusicId(sheetMusic.getId())
                .pdfFileList(pdfFileResponseDTOList)
                .build();
    }

    public SheetMusicResponseDTO.MySheetMusicPreViewListDTO mySheetMusicPreViewListDTO(Page<SheetMusic> mySheetMusicList){

        List<SheetMusicResponseDTO.MySheetMusicPreViewDTO> mySheetMusicPreViewDTOList = mySheetMusicList.stream()
                .map(SheetMusicMapper::mySheetMusicPreViewDTO).collect(Collectors.toList());

        return SheetMusicResponseDTO.MySheetMusicPreViewListDTO.builder()
                .mySheetMusicList(mySheetMusicPreViewDTOList)
                .isFirst(mySheetMusicList.isFirst())
                .isLast(mySheetMusicList.isLast())
                .listSize(mySheetMusicList.getSize())
                .totalElements(mySheetMusicList.getTotalElements())
                .totalPage(mySheetMusicList.getTotalPages())
                .build();
    }

    public SheetMusicResponseDTO.UploadSheetMusic toUploadSheetMusic(SheetMusic sheetMusic, PDFFile pdfFile) {
        return SheetMusicResponseDTO.UploadSheetMusic.builder()
                .sheetMusicId(sheetMusic.getId())
                .pdfFileId(pdfFile.getId())
                .pdfFileName(pdfFile.getFileName())
                .pdfFileUrl(pdfFile.getUrl())
                .build();
    }
}
