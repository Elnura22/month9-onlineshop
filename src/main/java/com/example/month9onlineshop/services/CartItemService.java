package com.example.month9onlineshop.services;

import com.example.month9onlineshop.entities.Cart;
import com.example.month9onlineshop.entities.CartItem;
import com.example.month9onlineshop.repositories.CartItemRepository;
import com.example.month9onlineshop.repositories.CartRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CartItemService {
    private final CartItemRepository cartItemRepository;
    private final CartRepository cartRepository;


    public List<CartItem> getAllCartItemsByCart(Long id) {
        Cart cart = cartRepository.findById(id).orElseThrow();
        return cartItemRepository.findAllByCart(cart);
    }

}
