package com.example.hanriver.service.service;

import com.example.hanriver.data.dto.MemberDto;
import com.example.hanriver.data.repository.MemberRepository;
import com.example.hanriver.domain.entity.Member;
import com.example.hanriver.domain.entity.Role;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    public void signUp(MemberDto memberDto) throws Exception {

        if (memberRepository.findByEmail(memberDto.getEmail()).isPresent()) {
            throw new Exception("이미 존재하는 이메일입니다.");
        }

        Member member = Member.builder()
                .email(memberDto.getEmail())
                .name(memberDto.getName())
                .socialType(memberDto.getSoicalType())
                .build();
        memberRepository.save(member);
    }

}
