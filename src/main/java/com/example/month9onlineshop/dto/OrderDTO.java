package com.example.month9onlineshop.dto;

import com.example.month9onlineshop.entities.Cart;
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
//                .date(order.getDate())
                .address(order.getAddress())
                .postIndex(order.getPostIndex())
//                .cart(order.getCart().getId())
                .totalSum(order.getTotalSum())
                .build();
    }

//    private LocalDateTime date;
    private String address;
    private Long postIndex;
//    private Long cart;
    private Long user;
    private Long item;
    private Long totalSum;
}
