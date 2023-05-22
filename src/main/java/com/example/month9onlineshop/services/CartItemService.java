package com.example.month9onlineshop.services;

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


    public void addToCart(Long itemId, String email) {
        User user = userRepository.getByEmail(email).orElseThrow();
        Item item = itemRepository.findById(itemId).orElseThrow();
        Cart cart = cartRepository.findByUserId(user).orElseThrow();
        CartItem cartItem = CartItem.builder()
                .item(item)
                .quantity(1L)
                .cart(cart)
                .build();
        cartItemRepository.save(cartItem);
    }


    public List<CartItem> showItemsByCart(String email) {
        User user = userRepository.getByEmail(email).orElseThrow();
        Cart cart = cartRepository.findByUserId(user).orElseThrow();
        return cartItemRepository.findAllByCart(cart);
    }


    public void deleteItemFromCart(Long itemId, String email) {
        User user = userRepository.getByEmail(email).orElseThrow();
        Cart cart = cartRepository.findByUserId(user).orElseThrow();
        Item item = itemRepository.findById(itemId).orElseThrow();

        CartItem cartItem = cartItemRepository.findById(item.getId()).orElseThrow();
        if (cartItem.getCart().equals(cart)) {
            cartItemRepository.delete(cartItem);
        } else {
            throw new IllegalArgumentException("cartItem does not belong to this cart");
        }
    }

    public void updateQuantity(Long cartItemId, Long quantity) {
        CartItem cartItem = cartItemRepository.findById(cartItemId).orElseThrow();
        if (quantity > 0) {
            cartItem.setQuantity(quantity);
            cartItemRepository.save(cartItem);
        } else {
            cartItemRepository.delete(cartItem);
        }
    }
}
