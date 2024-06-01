package com.oldcapstone.maack.sheetmusic.implement;

import com.oldcapstone.maack.common.annotation.Adapter;
import com.oldcapstone.maack.sheetmusic.persistence.PDFFile;
import com.oldcapstone.maack.sheetmusic.persistence.repository.PDFFileRepository;
import lombok.RequiredArgsConstructor;

@Adapter
@RequiredArgsConstructor
public class PDFFileCommandAdapter {
    private final PDFFileRepository pdfFileRepository;

    public PDFFile save(PDFFile pdfFile) {
        return pdfFileRepository.save(pdfFile);
    }
}
