package com.example.hanriver.data.dto;

import com.example.hanriver.domain.entity.Mileage;
import com.example.hanriver.domain.entity.SocialType;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString(of = {"member_email","member_nickname"})
public class MemberDto {

    private String email;

    private String name;

    private SocialType soicalType;

    private Mileage mileage;

    @Builder
    public MemberDto(String email, String name, SocialType soicalType, Mileage mileage) {
        this.email = email;
        this.name = name;
        this.soicalType = soicalType;
        this.mileage = mileage;
    }
}
