package com.oldcapstone.maack.sheetmusic.implement;

import com.oldcapstone.maack.common.annotation.Adapter;
import com.oldcapstone.maack.sheetmusic.persistence.MIDIFile;
import com.oldcapstone.maack.sheetmusic.persistence.repository.MIDIFileRepository;
import lombok.RequiredArgsConstructor;

@Adapter
@RequiredArgsConstructor
public class MIDIFileCommandAdapter {
    private final MIDIFileRepository midiFileRepository;

    public MIDIFile save(MIDIFile midiFile) {
        return midiFileRepository.save(midiFile);
    }
}
