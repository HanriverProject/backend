package com.example.hanriver.domain.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Long book_id;

    private String book_description;

    private String book_price;

    private String book_title;

    private String book_author;

    private String book_img_url;

    private String book_publisher;
}
