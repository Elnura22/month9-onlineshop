package com.example.month9onlineshop.controller;

import com.example.month9onlineshop.dto.OrderDTO;
import com.example.month9onlineshop.dto.UserDTO;
import com.example.month9onlineshop.entities.Order;
import com.example.month9onlineshop.services.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;

//    @GetMapping("/byUserId")
//    public ResponseEntity<List<Order>> getOrdersByUserId(@RequestParam Long userId) {
//        List<Order> orders = orderService.getOrdersByUserId(userId);
//        if (orders.isEmpty()) {
//            return ResponseEntity.noContent().build();
//        } else {
//            return ResponseEntity.ok(orders);
//        }
//    }


    @GetMapping("/ordersByUserId")
    public List<OrderDTO> getOrdersByUserId(@RequestParam Long userId) {
        return orderService.getOrdersByUserId(userId)
                .stream().map(OrderDTO::from).
                collect(Collectors.toList());
    }

}
