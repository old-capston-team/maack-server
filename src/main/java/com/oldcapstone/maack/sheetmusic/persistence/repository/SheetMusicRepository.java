package com.oldcapstone.maack.sheetmusic.persistence.repository;

import com.oldcapstone.maack.sheetmusic.persistence.SheetMusic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SheetMusicRepository extends JpaRepository<SheetMusic, Long> {
}
