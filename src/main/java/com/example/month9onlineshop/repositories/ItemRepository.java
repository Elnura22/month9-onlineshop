package com.example.month9onlineshop.repositories;

import com.example.month9onlineshop.entities.Item;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
//    Page<Item> findAllByName(String name, Pageable pageable);
//
//    Page<Item> findAllByCategory(String category, Pageable pageable);
//
//    Page<Item> findAllByPrice(Long price, Pageable pageable);

//    Page<Item> findAll(Pageable pageable);

//    Page<Item> search(@Param("keyword") String keyword, Pageable pageable);
//
//    Page<Item> searchAllByName(@Param("name") String name, Pageable pageable);

    Page<Item> findAllByName(@Param("name") String name, Pageable pageable);




//    Page<Item> searchAllByPrice(@Param("price") int price, Pageable pageable);

}
