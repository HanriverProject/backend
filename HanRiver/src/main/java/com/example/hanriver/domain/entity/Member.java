package com.example.hanriver.domain.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.security.AuthProvider;

@Entity
@Getter
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
@ToString(of = {"member_email","member_name"})
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;

    private String email;

    private String name;

    @Enumerated(EnumType.STRING)
    private SocialType socialType;

    private String refreshToken;

    private String socialId; // 로그인한 소셜 타입의 식별자 값 (일반 로그인인 경우 null)

    private String password;


    @Enumerated(EnumType.STRING)
    private Role role;



    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mileage_id")
    private Mileage mileage;

    @Builder
    public Member(String email, String name, SocialType socialType, String refreshToken, String socialId, String password, Role role) {
        this.email = email;
        this.name = name;
        this.socialType = socialType;
        this.refreshToken = refreshToken;
        this.socialId = socialId;
        this.password = password;
        this.role = role;
    }


    public void updateRefreshToken(String updateRefreshToken) {
        this.refreshToken = updateRefreshToken;
    }

    public void updateMember_name(String member_name){
        this.name = member_name;
    }

}
