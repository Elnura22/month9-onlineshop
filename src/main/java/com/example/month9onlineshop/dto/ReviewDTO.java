package com.example.month9onlineshop.dto;

import com.example.month9onlineshop.entities.Item;
import com.example.month9onlineshop.entities.Order;
import com.example.month9onlineshop.entities.Review;
import com.example.month9onlineshop.entities.User;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Data
@Builder(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
public class ReviewDTO {
    public static ReviewDTO from(Review review) {
        return builder()
                .id(review.getId())
                .text(review.getText())
                .date(review.getDate())
                .userId(review.getUserId())
                .itemId(review.getItemId())
                .build();
    }

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
