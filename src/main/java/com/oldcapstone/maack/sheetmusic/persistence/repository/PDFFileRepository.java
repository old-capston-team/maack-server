package com.oldcapstone.maack.sheetmusic.persistence.repository;

import com.oldcapstone.maack.sheetmusic.persistence.PDFFile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PDFFileRepository extends JpaRepository<PDFFile, Long> {
}
