package com.oldcapstone.maack.sheetmusic.implement;

import com.oldcapstone.maack.common.annotation.Adapter;
import com.oldcapstone.maack.sheetmusic.persistence.repository.SheetMusicRepository;
import lombok.RequiredArgsConstructor;

@Adapter
@RequiredArgsConstructor
public class SheetMusicCommandAdapter {
    private final SheetMusicRepository sheetMusicRepository;
}
