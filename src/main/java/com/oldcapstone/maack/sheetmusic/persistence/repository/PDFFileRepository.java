package com.oldcapstone.maack.sheetmusic.persistence.repository;

import com.oldcapstone.maack.sheetmusic.persistence.PDFFile;
import com.oldcapstone.maack.sheetmusic.persistence.SheetMusic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PDFFileRepository extends JpaRepository<PDFFile, Long> {
    PDFFile findBySheetMusic(SheetMusic sheetMusic);
}
