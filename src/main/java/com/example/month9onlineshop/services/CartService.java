package com.example.month9onlineshop.services;

import com.example.month9onlineshop.entities.Cart;
import com.example.month9onlineshop.entities.Order;
import com.example.month9onlineshop.repositories.CartRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CartService {
    private final CartRepository cartRepository;

    public List<Cart> getCartByUserId(Long userId) {
        return cartRepository.findByUserId(userId);
    }
}
