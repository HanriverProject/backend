package com.example.hanriver.infrastructure.web.auth.oauth2.service;

import com.example.hanriver.data.repository.MemberRepository;
import com.example.hanriver.domain.entity.Member;
import com.example.hanriver.service.service.MemberService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class LoginService implements UserDetailsService {

    private MemberRepository memberRepository;

    @Override
    public UserDetails loadUserByUsername(String member_email) throws UsernameNotFoundException {
        Member member = memberRepository.findByEmail(member_email)
                .orElseThrow(() -> new UsernameNotFoundException("해당 이메일이 존재하지 않습니다."));

        return org.springframework.security.core.userdetails.User.builder()
                .username(member.getEmail())
                .password(member.getPassword())
                .roles(member.getRole().name())
                .build();
    }
}
