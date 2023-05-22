package com.example.month9onlineshop.entities;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.*;
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


    @Min(value = 100000, message = "Минимальное значение почтового индекса должно быть 10000")
    @Max(value = 999999, message = "Максимальное значение почтового индекса должно быть 99999")
    @Column(length = 128)
    private Long postIndex;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cart_id")
    private Cart cart;


    @Positive
    private Long totalSum;
}
