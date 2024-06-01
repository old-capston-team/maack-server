package com.oldcapstone.maack.sheetmusic.implement;

import com.oldcapstone.maack.common.annotation.Adapter;
import com.oldcapstone.maack.sheetmusic.persistence.MIDIFile;
import com.oldcapstone.maack.sheetmusic.persistence.MusicXMLFile;
import com.oldcapstone.maack.sheetmusic.persistence.PDFFile;
import com.oldcapstone.maack.sheetmusic.persistence.SheetMusic;
import com.oldcapstone.maack.sheetmusic.persistence.repository.MIDIFileRepository;
import lombok.RequiredArgsConstructor;

@Adapter
@RequiredArgsConstructor
public class MidiFileQueryAdapter {
    private final PDFFileQueryAdapter pdfFileQueryAdapter;
    private final MIDIFileRepository midiFileRepository;

    public MIDIFile findByPDFFile(Long sheetMusicId) {
        PDFFile pdfFile = pdfFileQueryAdapter.findBySheetMusic(sheetMusicId);
        return midiFileRepository.findByPdfFile(pdfFile);
    }
}
