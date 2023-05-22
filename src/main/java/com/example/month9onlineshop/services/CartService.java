package com.example.month9onlineshop.services;

import com.example.month9onlineshop.entities.Cart;
import com.example.month9onlineshop.repositories.CartRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CartService {
    private final CartRepository cartRepository;

    public void createCartForUser(Cart cart){


    }
}
