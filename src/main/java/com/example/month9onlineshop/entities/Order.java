package com.example.month9onlineshop.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
@Entity
@Table(name = "orders")
@Data
@Builder
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@NoArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime date;
    @Column(length = 128)
    private String address;
    @Column(length = 128)
    private Long postIndex;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user_id;
    @ManyToOne
    @JoinColumn(name = "item_id")
    private Item item_id;

    private Long totalSum;
}
