package com.oldcapstone.maack.member.business;

import com.oldcapstone.maack.member.implement.MemberCommandAdapter;
import com.oldcapstone.maack.member.implement.MemberQueryAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberQueryAdapter memberQueryAdapter;
    private final MemberCommandAdapter memberCommandAdapter;
    private final MemberMapper memberMapper;
}
