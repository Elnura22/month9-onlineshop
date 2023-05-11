package com.example.month9onlineshop.controller;

import com.example.month9onlineshop.dto.OrderDTO;
import com.example.month9onlineshop.services.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;

    @GetMapping("/ordersByUserId")
    public List<OrderDTO> getOrdersByUserId(@RequestParam Long userId) {
        return orderService.getOrderByUser(userId)
                .stream().map(OrderDTO::from).
                collect(Collectors.toList());
    }

@ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<String> handleNoSuchElementException(NoSuchElementException e){
        return ResponseEntity.badRequest().body("user is not exists with this id");
}
}
