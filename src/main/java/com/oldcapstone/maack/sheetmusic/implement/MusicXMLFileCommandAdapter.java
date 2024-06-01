package com.oldcapstone.maack.sheetmusic.implement;

import com.oldcapstone.maack.common.annotation.Adapter;
import com.oldcapstone.maack.sheetmusic.persistence.MusicXMLFile;
import com.oldcapstone.maack.sheetmusic.persistence.repository.MusicXMLFIleRepository;
import lombok.RequiredArgsConstructor;

@Adapter
@RequiredArgsConstructor
public class MusicXMLFileCommandAdapter {
    private final MusicXMLFIleRepository musicXMLFIleRepository;

    public MusicXMLFile save(MusicXMLFile musicXMLFile) {
        return musicXMLFIleRepository.save(musicXMLFile);
    }
}
