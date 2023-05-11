package com.example.month9onlineshop.repositories;

import com.example.month9onlineshop.entities.CartItem;
import com.example.month9onlineshop.entities.User;
import org.springframework.data.repository.CrudRepository;

public interface CartItemRepository extends CrudRepository<CartItem, Long> {
//    CartItem findCartItemsByCartId_UserId(User user);
}
