package com.example.month9onlineshop.repositories;

import com.example.month9onlineshop.entities.Cart;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CartRepository extends CrudRepository<Cart,Long> {

    List<Cart> findByUserId(Long userId);
}
