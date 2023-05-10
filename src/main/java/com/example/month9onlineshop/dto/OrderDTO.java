package com.example.month9onlineshop.dto;

import com.example.month9onlineshop.entities.Order;
import lombok.*;

import java.time.LocalDateTime;

@Data
@Builder(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
public class OrderDTO {
    public static OrderDTO from(Order order) {
        return builder()
                .id(order.getId())
                .date(order.getDate())
                .address(order.getAddress())
                .postIndex(order.getPostIndex())
                .user(order.getUser().getId())
                .item(order.getItem().getId())
                .totalSum(order.getTotalSum())
                .build();
    }

    private Long id;
    private LocalDateTime date;
    private String address;
    private Long postIndex;
    private Long user;
    private Long item;
    private Long totalSum;
}
