package com.example.month9onlineshop.dto;

import com.example.month9onlineshop.entities.Item;
import com.example.month9onlineshop.entities.Order;
import com.example.month9onlineshop.entities.User;
import jakarta.persistence.*;
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
                .userId(order.getUserId())
                .itemId(order.getItemId())
                .totalSum(order.getTotalSum())
                .build();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime date;
    @Column(length = 128)
    private String address;
    @Column(length = 128)
    private Long postIndex;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User userId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id")
    private Item itemId;

    private Long totalSum;
}
