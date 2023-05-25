package com.example.month9onlineshop.repositories;

import com.example.month9onlineshop.entities.Cart;
import com.example.month9onlineshop.entities.CartItem;
import com.example.month9onlineshop.entities.Item;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CartItemRepository extends CrudRepository<CartItem, Long> {
    List<CartItem> findAllByCart(Cart cart);
    CartItem findByCart(Cart cart);

    List<CartItem> getDistinctByCart(Cart cart);

    CartItem findAllByItem(Item item);

}
