package com.example.month9onlineshop.repositories;

import com.example.month9onlineshop.entities.Item;
import com.example.month9onlineshop.entities.Review;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ReviewRepository extends CrudRepository<Review, Long> {
    List<Review> findAllByItem(Item item);
}
