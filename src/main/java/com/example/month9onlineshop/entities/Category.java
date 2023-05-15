package com.example.month9onlineshop.entities;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "categories")
@Data
@Builder
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@NoArgsConstructor
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 128)
    private String name;

}
