package com.example.month9onlineshop.repositories;

import com.example.month9onlineshop.entities.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface ItemRepository extends CrudRepository<Item,Long> {
    Item findAllByName(String name);
    Item findAllByPrice(Long price);
    Item findAllByCategory(String category);
}
