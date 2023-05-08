package com.example.month9onlineshop.services;

import com.example.month9onlineshop.entities.Review;
import com.example.month9onlineshop.repositories.ReviewRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ReviewService {
    private final ReviewRepository reviewRepository;

    public List<Review> getReviewsByItemId(Long itemId){
        return reviewRepository.findAllByItemId(itemId);
    }
}
