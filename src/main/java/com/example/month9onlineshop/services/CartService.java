package com.example.month9onlineshop.services;

import com.example.month9onlineshop.entities.Cart;
import com.example.month9onlineshop.entities.Order;
import com.example.month9onlineshop.entities.User;
import com.example.month9onlineshop.repositories.CartRepository;
import com.example.month9onlineshop.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CartService {
    private final CartRepository cartRepository;
    private final UserRepository userRepository;
//
//    public List<Cart> getCartByUserId(Long userId) {
//        User user = userRepository.findById(userId).orElseThrow();
//        return cartRepository.findByUser(user);
//    }
//}
}
