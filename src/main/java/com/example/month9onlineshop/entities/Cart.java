package com.example.month9onlineshop.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "carts")
@Data
@Builder
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@NoArgsConstructor
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user_id;
    @ManyToOne
    @JoinColumn(name = "item_id")
    private Item item_id;
}
