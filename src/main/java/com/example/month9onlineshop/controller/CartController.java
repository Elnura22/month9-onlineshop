package com.example.month9onlineshop.controller;

import com.example.month9onlineshop.services.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/cart")
public class CartController {
    private final CartService cartService;

    //add item to cart

    //delete item from cart by id

//    @GetMapping("/cartByUserId")
//    public List<CartDTO> getCartByUserId(@RequestParam Long userId) {
//        return cartService.getCartByUserId(userId)
//                .stream().map(CartDTO::from).
//                collect(Collectors.toList());
//    }

}