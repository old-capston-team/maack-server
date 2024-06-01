package com.oldcapstone.maack.sheetmusic.exception;

import com.oldcapstone.maack.common.exception.BaseCodeException;
import com.oldcapstone.maack.member.exception.MemberErrorCode;
import com.oldcapstone.maack.member.exception.MemberNotFoundException;

public class SheetMusicNotFoundException extends BaseCodeException {
    public static BaseCodeException EXCEPTION = new SheetMusicNotFoundException();

    private SheetMusicNotFoundException() {
        super(SheetMusicErrorCode.SHEET_MUSIC_NOT_FOUND);
    }
}
