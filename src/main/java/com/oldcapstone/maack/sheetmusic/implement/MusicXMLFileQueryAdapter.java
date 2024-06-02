package com.oldcapstone.maack.sheetmusic.implement;

import com.oldcapstone.maack.common.annotation.Adapter;
import com.oldcapstone.maack.sheetmusic.persistence.MIDIFile;
import com.oldcapstone.maack.sheetmusic.persistence.MusicXMLFile;
import com.oldcapstone.maack.sheetmusic.persistence.PDFFile;
import com.oldcapstone.maack.sheetmusic.persistence.SheetMusic;
import com.oldcapstone.maack.sheetmusic.persistence.repository.MusicXMLFIleRepository;
import lombok.RequiredArgsConstructor;

@Adapter
@RequiredArgsConstructor
public class MusicXMLFileQueryAdapter {
    private final SheetMusicQueryAdapter sheetMusicQueryAdapter;
    private final MidiFileQueryAdapter midiFileQueryAdapter;
    private final MusicXMLFIleRepository musicXMLFIleRepository;

    public MusicXMLFile findByMidiFile(MIDIFile midiFile){
        return musicXMLFIleRepository.findByMidiFile(midiFile);
    }
}
