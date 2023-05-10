package com.example.month9onlineshop.entities;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "reviews")
@Data
@Builder
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@NoArgsConstructor
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String text;
    private LocalDateTime date;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User userId;
    @ManyToOne
    @JoinColumn(name = "item_id")
    private Item itemId;
}
