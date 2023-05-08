package com.example.month9onlineshop.controller;

import com.example.month9onlineshop.dto.OrderDTO;
import com.example.month9onlineshop.dto.ReviewDTO;
import com.example.month9onlineshop.services.ReviewService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;
@RestController
@RequiredArgsConstructor
@RequestMapping("/reviews")
public class ReviewController {
    private final ReviewService reviewService;
    @GetMapping("/reviewsByItemId")
    public List<ReviewDTO> getReviewByItemId(@RequestParam Long itemId) {
        return reviewService.getReviewsByItemId(itemId)
                .stream().map(ReviewDTO::from).
                collect(Collectors.toList());
    }
}
