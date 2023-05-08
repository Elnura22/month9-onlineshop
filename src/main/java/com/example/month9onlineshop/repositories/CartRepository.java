package com.example.month9onlineshop.repositories;

import com.example.month9onlineshop.entities.Cart;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CartRepository extends CrudRepository<Cart,Long> {

    List<Cart> findByUserId(Long userId);
}
