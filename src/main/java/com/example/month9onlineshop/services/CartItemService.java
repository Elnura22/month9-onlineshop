package com.example.month9onlineshop.services;

import com.example.month9onlineshop.dto.CartItemDTO;
import com.example.month9onlineshop.entities.Cart;
import com.example.month9onlineshop.entities.CartItem;
import com.example.month9onlineshop.entities.Item;
import com.example.month9onlineshop.entities.User;
import com.example.month9onlineshop.repositories.CartItemRepository;
import com.example.month9onlineshop.repositories.CartRepository;
import com.example.month9onlineshop.repositories.ItemRepository;
import com.example.month9onlineshop.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CartItemService {
    private final CartItemRepository cartItemRepository;
    private final CartRepository cartRepository;
    private final UserRepository userRepository;
    private final ItemRepository itemRepository;


    public List<CartItem> getAllCartItemsByCart(Long id) {
        Cart cart = cartRepository.findById(id).orElseThrow();
        return cartItemRepository.findAllByCart(cart);
    }

//    public void addToCart(CartItemDTO cartItem) {
//        if (cartItem.getCart() == null || cartItem.getItem() == null || cartItem.getQuantity() == null) {
//            throw new IllegalArgumentException("Необходимые поля не заполнены.");
//        }
//        cartItemRepository.save(cartItem);
//    }

   public void addToCart(CartItemDTO cartItemDTO, String email, Long itemId) {
        User user = userRepository.getByEmail(email).orElseThrow();
        Item item = itemRepository.findById(itemId).orElseThrow();
        Cart cart = cartRepository.findByUserId(user.getId()).orElseThrow();
        CartItem cartItem = CartItem.builder()
                .item(item)
                .quantity(cartItemDTO.getQuantity())
                .cart(cart)
                .build();
      cartItemRepository.save(cartItem);
    }

}
