package com.oldcapstone.maack.member.implement;

import com.oldcapstone.maack.common.annotation.Adapter;
import com.oldcapstone.maack.member.exception.MemberNotFoundException;
import com.oldcapstone.maack.member.persistence.Member;
import com.oldcapstone.maack.member.persistence.repository.MemberRepository;
import lombok.RequiredArgsConstructor;

@Adapter
@RequiredArgsConstructor
public class MemberQueryAdapter {
    private final MemberRepository memberRepository;

    public Member findById(Long memberId) {
        return memberRepository
                .findById(memberId)
                .orElseThrow(() -> MemberNotFoundException.EXCEPTION);
    }
}
