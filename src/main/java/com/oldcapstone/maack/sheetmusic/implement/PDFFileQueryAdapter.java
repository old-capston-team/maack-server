package com.oldcapstone.maack.sheetmusic.implement;

import com.oldcapstone.maack.common.annotation.Adapter;
import com.oldcapstone.maack.sheetmusic.persistence.PDFFile;
import com.oldcapstone.maack.sheetmusic.persistence.SheetMusic;
import com.oldcapstone.maack.sheetmusic.persistence.repository.PDFFileRepository;
import lombok.RequiredArgsConstructor;

@Adapter
@RequiredArgsConstructor
public class PDFFileQueryAdapter {
    private final SheetMusicQueryAdapter sheetMusicQueryAdapter;
    private final PDFFileRepository pdfFileRepository;

    public PDFFile findBySheetMusic(Long sheetMusicId){
        SheetMusic sheetMusic = sheetMusicQueryAdapter.findById(sheetMusicId);
        return pdfFileRepository.findBySheetMusic(sheetMusic);
    }
}
