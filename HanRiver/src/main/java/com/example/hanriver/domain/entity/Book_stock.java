package com.example.hanriver.domain.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Book_stock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long stock_Id;

    private int book_amount;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "book_id")
    private Book book;

}
