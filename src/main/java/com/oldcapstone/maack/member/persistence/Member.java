package com.oldcapstone.maack.member.persistence;

import com.oldcapstone.maack.common.enums.MemberRole;
import com.oldcapstone.maack.common.enums.SocialType;
import com.oldcapstone.maack.common.persistence.BaseDateTimeEntity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Member extends BaseDateTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Builder.Default
    @Enumerated(EnumType.STRING)
    private MemberRole role = MemberRole.USER;

    private String socialId;

    @Builder.Default
    @Enumerated(EnumType.STRING)
    private SocialType socialType = SocialType.KAKAO;

    private String profileImgUrl;

    private String email;
}

