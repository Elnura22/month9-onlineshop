package com.example.month9onlineshop.entities;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Positive;

@Entity
@Table(name = "cart_items")
@Data
@Builder
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@NoArgsConstructor
public class CartItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cart_id")
    private Cart cart;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id")
    private Item item;
    @Column
    @Positive
    private Long quantity;
}
