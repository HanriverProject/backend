package com.example.hanriver.infrastructure.web.controller;

import com.example.hanriver.data.dto.MemberDto;
import com.example.hanriver.service.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MemberController {

    private MemberService memberService;

    @PostMapping("/sign-up")
    public String signUp(@RequestBody MemberDto memberDto) throws Exception {
        memberService.signUp(memberDto);
        return "회원가입 성공";
    }
}
