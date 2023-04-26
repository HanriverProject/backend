package com.example.photofolio.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor
public class Board {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long B_id;

    private String b_Title;

    private String b_Contents;

    private String b_Writer;
    @CreationTimestamp
    private LocalDateTime b_CreateTime;
    @UpdateTimestamp
    private LocalDateTime b_UpdateTime;

    @Builder
    public Board(String b_title, String b_contents, String b_writer, LocalDateTime b_createtime, LocalDateTime b_updatetime)
    {
        this.b_Title = b_title;
        this.b_Contents =b_contents;
        this.b_Writer =b_writer;
        this.b_CreateTime =b_createtime;
        this.b_UpdateTime =b_createtime;
    }



}
