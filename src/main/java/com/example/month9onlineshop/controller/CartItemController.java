package com.example.month9onlineshop.controller;

import com.example.month9onlineshop.dto.CartItemDTO;
import com.example.month9onlineshop.services.CartItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/cartItems")
public class CartItemController {
    private final CartItemService cartItemService;

    @GetMapping("/byCartId")
    public List<CartItemDTO> getCartItemsByCart(@RequestParam Long cartId) {
        return cartItemService.getAllCartItemsByCart(cartId)
                .stream().map(CartItemDTO::from)
                .collect(Collectors.toList());
    }

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<String> handleNoSuchElementException(NoSuchElementException e) {
        return ResponseEntity.badRequest().body("user is not exists with this id");
    }
}
