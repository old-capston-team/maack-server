package com.oldcapstone.maack.sheetmusic.implement;

import com.oldcapstone.maack.common.annotation.Adapter;
import com.oldcapstone.maack.member.exception.MemberNotFoundException;
import com.oldcapstone.maack.member.implement.MemberQueryAdapter;
import com.oldcapstone.maack.member.persistence.Member;
import com.oldcapstone.maack.sheetmusic.exception.SheetMusicNotFoundException;
import com.oldcapstone.maack.sheetmusic.persistence.PDFFile;
import com.oldcapstone.maack.sheetmusic.persistence.SheetMusic;
import com.oldcapstone.maack.sheetmusic.persistence.repository.PDFFileRepository;
import com.oldcapstone.maack.sheetmusic.persistence.repository.SheetMusicRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

@Adapter
@RequiredArgsConstructor
public class SheetMusicQueryAdapter {
    private final SheetMusicRepository sheetMusicRepository;
    private final MemberQueryAdapter memberQueryAdapter;

    public Page<SheetMusic> findByMember(Long memberId, Integer page){
        Member member = memberQueryAdapter.findById(memberId);

        return sheetMusicRepository
                .findAllByMember(member,PageRequest.of(page, 10, Sort.by(Sort.Direction.DESC, "createdAt")));
    }

    public SheetMusic findById(Long sheetMusicId){
        return sheetMusicRepository
                .findById(sheetMusicId)
                .orElseThrow(() -> SheetMusicNotFoundException.EXCEPTION);
    }
}
