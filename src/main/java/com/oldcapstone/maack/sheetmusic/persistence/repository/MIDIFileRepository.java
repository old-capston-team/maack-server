package com.oldcapstone.maack.sheetmusic.persistence.repository;

import com.oldcapstone.maack.sheetmusic.persistence.MIDIFile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MIDIFileRepository extends JpaRepository<MIDIFile, Long> {
}
