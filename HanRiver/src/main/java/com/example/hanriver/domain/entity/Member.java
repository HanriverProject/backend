package com.example.hanriver.domain.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long member_id;

    private String member_email;

    private String member_name;

    private String oauth_type;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mileage_id")
    private Mileage mileage;


}
