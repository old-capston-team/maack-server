package com.oldcapstone.maack.sheetmusic.persistence.repository;

import com.oldcapstone.maack.sheetmusic.persistence.MusicXMLFile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MusicXMLFIleRepository extends JpaRepository<MusicXMLFile, Long> {
}
