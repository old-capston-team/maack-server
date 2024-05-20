package com.oldcapstone.maack.sheetmusic.persistence;

import com.oldcapstone.maack.common.persistence.BaseDateTimeEntity;
import com.oldcapstone.maack.member.persistence.Member;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class SheetMusic extends BaseDateTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @OneToMany(mappedBy = "sheetMusic", cascade = CascadeType.ALL)
    private List<PDFFile> pdfFileList = new ArrayList<>();
    // TODO - 어떤 멤버의 악보인지 연관관계 추가하기
}
