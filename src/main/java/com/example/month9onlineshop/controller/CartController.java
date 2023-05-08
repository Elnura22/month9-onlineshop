package com.example.month9onlineshop.controller;

import com.example.month9onlineshop.dto.CartDTO;
import com.example.month9onlineshop.dto.OrderDTO;
import com.example.month9onlineshop.services.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/cart")
public class CartController {
    private final CartService cartService;

    //add item to cart

    //delete item from cart by id

    @GetMapping("/cartByUserId")
    public List<CartDTO> getCartByUserId(@RequestParam Long userId) {
        return cartService.getCartByUserId(userId)
                .stream().map(CartDTO::from).
                collect(Collectors.toList());
    }

}
