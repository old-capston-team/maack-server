package com.oldcapstone.maack.sheetmusic.exception;

import com.oldcapstone.maack.common.exception.BaseCodeException;

public class MidiFileNotFoundException extends BaseCodeException {
    public static BaseCodeException EXCEPTION = new MidiFileNotFoundException();

    private MidiFileNotFoundException() { super(SheetMusicErrorCode.MIDI_FILE_NOT_FOUND);}
}
