package com.example.month9onlineshop.repositories;

import com.example.month9onlineshop.entities.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order, Long> {

}
