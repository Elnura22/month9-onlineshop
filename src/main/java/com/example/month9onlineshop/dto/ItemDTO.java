package com.example.month9onlineshop.dto;

import com.example.month9onlineshop.entities.Item;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Data
@Builder(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
public class ItemDTO {


    public static ItemDTO from(Item item) {
        return builder()
                .id(item.getId())
                .name(item.getName())
                .image(item.getImage())
                .description(item.getDescription())
                .category(item.getCategory())
                .color(item.getColor())
                .size(item.getSize())
                .amount(item.getAmount())
                .price(item.getPrice())
                .build();
    }

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
    private Long amount;
    private Long price;
}
