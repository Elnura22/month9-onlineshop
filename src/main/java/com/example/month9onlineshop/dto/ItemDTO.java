package com.example.month9onlineshop.dto;

import com.example.month9onlineshop.entities.Item;
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

    private Long id;
    private String name;
    private String image;
    private String description;
    private String category;
    private String color;
    private String size;
    private Long amount;
    private Long price;
}
