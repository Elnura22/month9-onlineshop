package com.example.month9onlineshop.controller;

import com.example.month9onlineshop.dto.ReviewDTO;
import com.example.month9onlineshop.services.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;
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

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<String> handleNoSuchElementException(NoSuchElementException e) {
        return ResponseEntity.badRequest().body("error, user is not exists with this id");
    }
}
