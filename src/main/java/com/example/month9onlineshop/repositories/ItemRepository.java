package com.example.month9onlineshop.repositories;

import com.example.month9onlineshop.entities.CartItem;
import com.example.month9onlineshop.entities.Item;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {


    Page<Item> findAllByName(@Param("name") String name, Pageable pageable);
    List<Item> findAll();


}

