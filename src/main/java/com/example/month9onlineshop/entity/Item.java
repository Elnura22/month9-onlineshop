package com.example.month9onlineshop.entity;

import jakarta.persistence.*;
import lombok.*;
@Entity
@Table(name = "items")
@Data
@Builder
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@NoArgsConstructor
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 128)
    private String name;
    @Column(length = 128)
    private String image;
    @Column(length = 128)
    private String description;
    @Column(length = 128)
    private String category;
    private Long amount;
    private Long price;
}
