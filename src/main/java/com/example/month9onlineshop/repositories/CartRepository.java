package com.example.month9onlineshop.repositories;

import com.example.month9onlineshop.entities.Cart;
import com.example.month9onlineshop.entities.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

public interface CartRepository extends CrudRepository<Cart,Long> {

    Optional<Cart> findByUserId(User userId);

    List<Cart> findAllByUserId(User user);
}
