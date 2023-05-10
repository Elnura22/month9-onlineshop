package com.example.month9onlineshop.entities;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Positive;

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
    @Column(length = 128)
    private String color;
    @Column(length = 128)
    private String size;
    @Positive
    private Long amount;
    @Positive
    private Long price;
//    @OneToMany(cascade = {CascadeType.ALL})
//    private Set<Review> reviews;
}
