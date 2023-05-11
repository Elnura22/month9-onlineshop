package com.example.month9onlineshop.controller;

import com.example.month9onlineshop.services.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.NoSuchElementException;

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

//    @ExceptionHandler(NoSuchElementException.class)
//    public ResponseEntity<String> handleNoSuchElementException(NoSuchElementException e){
//        return ResponseEntity.badRequest().body("user is not exists with this id");
//    }

}