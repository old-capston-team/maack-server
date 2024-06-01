package com.oldcapstone.maack.sheetmusic.persistence.repository;

import com.oldcapstone.maack.sheetmusic.persistence.MIDIFile;
import com.oldcapstone.maack.sheetmusic.persistence.PDFFile;
import com.oldcapstone.maack.sheetmusic.persistence.SheetMusic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MIDIFileRepository extends JpaRepository<MIDIFile, Long> {
    MIDIFile findByPdfFile(PDFFile pdfFile);
}
