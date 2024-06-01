package com.oldcapstone.maack.sheetmusic.persistence.repository;

import com.oldcapstone.maack.sheetmusic.persistence.MIDIFile;
import com.oldcapstone.maack.sheetmusic.persistence.MusicXMLFile;
import com.oldcapstone.maack.sheetmusic.persistence.SheetMusic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MusicXMLFIleRepository extends JpaRepository<MusicXMLFile, Long> {
    MusicXMLFile findByMidiFile(MIDIFile midiFile);
}
