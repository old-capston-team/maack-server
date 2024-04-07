package com.oldcapstone.maack.member.implement;

import com.oldcapstone.maack.common.annotation.Adapter;
import com.oldcapstone.maack.member.persistence.repository.MemberRepository;
import lombok.RequiredArgsConstructor;

@Adapter
@RequiredArgsConstructor
public class MemberQueryAdapter {
    private final MemberRepository memberRepository;
}
