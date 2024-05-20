package com.oldcapstone.maack.sheetmusic.persistence.repository;

import com.oldcapstone.maack.member.persistence.Member;
import com.oldcapstone.maack.sheetmusic.persistence.SheetMusic;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SheetMusicRepository extends JpaRepository<SheetMusic, Long> {

    Page<SheetMusic> findAllByMember(Member member, PageRequest pageRequest);
}
