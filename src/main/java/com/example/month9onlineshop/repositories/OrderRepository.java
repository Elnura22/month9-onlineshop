package com.example.month9onlineshop.repositories;

import com.example.month9onlineshop.entities.Cart;
import com.example.month9onlineshop.entities.Order;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends CrudRepository<Order, Long> {
//    List<Order> findByUser(User user);

    List<Order> findAllByCart(Cart cart);

    List<Order> getOrdersByCart(Cart cart);


}
