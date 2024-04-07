package com.oldcapstone.maack.member.business;

import com.oldcapstone.maack.member.implement.MemberCommandAdapter;
import com.oldcapstone.maack.member.implement.MemberQueryAdapter;
import com.oldcapstone.maack.member.persistence.Member;
import com.oldcapstone.maack.member.presentation.dto.MemberResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberService {
    private final MemberQueryAdapter memberQueryAdapter;
    private final MemberCommandAdapter memberCommandAdapter;
    private final MemberMapper memberMapper;

    public MemberResponseDTO.MemberDetail getMemberDetail(Long id) {
        Member member = memberQueryAdapter.findById(id);
        return memberMapper.toMemberDetail(member);
    }
}
