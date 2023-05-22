package com.example.month9onlineshop.services;

import com.example.month9onlineshop.dto.OrderDTO;
import com.example.month9onlineshop.entities.*;
import com.example.month9onlineshop.repositories.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private final UserRepository userRepository;
    private final CartRepository cartRepository;
    private final CartItemRepository cartItemRepository;


    public void makeOrder(String email, String address, Long postIndex) {
        User user = userRepository.getByEmail(email).orElseThrow();
        Cart cart = cartRepository.findByUserId(user).orElseThrow();

        long totalSumOfOrder = 0L;
        List<CartItem> list = cartItemRepository.findAllByCart(cart);
        for (CartItem cartItem : list) {
            long price = cartItem.getItem().getPrice();
            long quantity = cartItem.getQuantity();
            long multiplication = price * quantity;
            totalSumOfOrder += multiplication;
        }

        Order order = Order.builder()
                .date(LocalDateTime.now())
                .address(address)
                .postIndex(postIndex)
                .cart(cart)
                .totalSum(totalSumOfOrder)
                .build();
        orderRepository.save(order);

    }

    public List<Order> showOrdersByCart(String email) {
        User user = userRepository.getByEmail(email).orElseThrow();
        Cart cart = cartRepository.findByUserId(user).orElseThrow();
        return orderRepository.getOrdersByCart(cart);
    }
}
