package com.example.month9onlineshop.repositories;

import com.example.month9onlineshop.entities.Item;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
    Page<Item> findAllByName(String name, Pageable pageable);
    Page<Item> findAllByCategory(String category, Pageable pageable);
    Page<Item> findAllByPrice(Long price, Pageable pageable);

    Page<Item> findAll(Pageable pageable);



//    Slice<Item> findAll(org.springframework.data.domain.Pageable pageable);

//    Item findAllByName(String name);
//    Item findAllByPrice(Long price);
//    Item findAllByCategory(String category);
}
