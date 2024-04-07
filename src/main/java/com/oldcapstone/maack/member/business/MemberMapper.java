package com.oldcapstone.maack.member.business;

import com.oldcapstone.maack.common.annotation.Mapper;
import com.oldcapstone.maack.member.persistence.Member;
import com.oldcapstone.maack.member.presentation.dto.MemberResponseDTO;

@Mapper
public class MemberMapper {
    public MemberResponseDTO.MemberDetail toMemberDetail(Member member) {
        return MemberResponseDTO.MemberDetail.builder()
                .memberId(member.getId())
                .name(member.getName())
                .build();
    }
}
