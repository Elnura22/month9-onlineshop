package com.example.month9onlineshop.repositories;

import com.example.month9onlineshop.entities.Cart;
import com.example.month9onlineshop.entities.Item;
import com.example.month9onlineshop.entities.Order;
import com.example.month9onlineshop.entities.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends CrudRepository<Order, Long> {

    List<Order> findAllByUser(User user);
}
