package com.oldcapstone.maack.member.presentation;

import com.oldcapstone.maack.member.business.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/v1/members")
@RestController
@RequiredArgsConstructor
public class MemberApi {
    private final MemberService memberService;

}
