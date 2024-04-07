package com.oldcapstone.maack.member.presentation;

import com.oldcapstone.maack.common.presentation.ApiResponse;
import com.oldcapstone.maack.member.business.MemberService;
import com.oldcapstone.maack.member.presentation.dto.MemberResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/v1/members")
@RestController
@RequiredArgsConstructor
public class MemberApi {
    private final MemberService memberService;

    @GetMapping("/{id}")
    public ApiResponse<MemberResponseDTO.MemberDetail> getMemberDetail(
            @PathVariable final Long id) {
        return ApiResponse.onSuccess(memberService.getMemberDetail(id));
    }
}
