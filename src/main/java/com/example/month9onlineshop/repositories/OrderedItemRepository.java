package com.example.month9onlineshop.repositories;

import com.example.month9onlineshop.entities.Item;
import com.example.month9onlineshop.entities.Order;
import com.example.month9onlineshop.entities.OrderedItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderedItemRepository extends JpaRepository<OrderedItem, Long> {


    List<OrderedItem> findAllByItemAndOrder(Item item, Order order);


}
