package com.example.month9onlineshop.repositories;

import com.example.month9onlineshop.entities.Review;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ReviewRepository extends CrudRepository<Review, Long> {
    List<Review> findAll(Long itemId);
}
