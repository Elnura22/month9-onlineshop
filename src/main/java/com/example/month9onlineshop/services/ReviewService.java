package com.example.month9onlineshop.services;

import com.example.month9onlineshop.entities.Item;
import com.example.month9onlineshop.entities.Review;
import com.example.month9onlineshop.repositories.ItemRepository;
import com.example.month9onlineshop.repositories.ReviewRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ReviewService {
    private final ReviewRepository reviewRepository;
    private final ItemRepository itemRepository;

    public List<Review> getReviewsByItemId(Long itemId){
        Item item = itemRepository.findById(itemId).orElseThrow();
        return reviewRepository.findAllByItem(item);
    }
}
