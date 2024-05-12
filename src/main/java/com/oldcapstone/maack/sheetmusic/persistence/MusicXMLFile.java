package com.oldcapstone.maack.sheetmusic.persistence;

import com.oldcapstone.maack.common.persistence.BaseDateTimeEntity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class MusicXMLFile extends BaseDateTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "midi_file_id")
    private MIDIFile midiFile;

    @Column(nullable = false)
    private String fileName;

    @Column(nullable = false, length = 1000)
    private String url; // filePath

    private Long fileSize;
}
