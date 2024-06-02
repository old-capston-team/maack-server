package com.oldcapstone.maack.sheetmusic.persistence;

import com.oldcapstone.maack.common.persistence.BaseDateTimeEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class PDFFile extends BaseDateTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sheet_music_id", nullable = false)
    private SheetMusic sheetMusic;

    @Column(nullable = false)
    private String fileName;

    @Column(nullable = false, length = 1000)
    private String url; // filePath

    private Long fileSize;

    @OneToMany(mappedBy = "pdfFile", cascade = CascadeType.ALL)
    private List<MIDIFile> midiFileList = new ArrayList<>();
}
