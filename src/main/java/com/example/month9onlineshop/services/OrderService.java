package com.example.month9onlineshop.services;

import com.example.month9onlineshop.entities.Order;
import com.example.month9onlineshop.entities.User;
import com.example.month9onlineshop.repositories.OrderRepository;
import com.example.month9onlineshop.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class OrderService {
   private final OrderRepository orderRepository;
   private final UserRepository userRepository;

//    public List<Order> getOrdersByUserId(Long userId) {
//        return orderRepository.findByUserId(userId);
//    }

    public List<Order> getOrderByUser(Long id){
        User user = userRepository.findById(id).orElseThrow();
        List<Order> orders =  orderRepository.findByUser(user);
        return orders;
    }











}
