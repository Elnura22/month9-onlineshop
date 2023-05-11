package com.example.month9onlineshop.dto;

import com.example.month9onlineshop.entities.Review;
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
                .userId(review.getUser().getId())
                .itemId(review.getItem().getId())
                .build();
    }

    private Long id;
    private String text;
    private LocalDateTime date;
    private Long userId;
    private Long itemId;
}
