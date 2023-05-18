package com.example.month9onlineshop.dto;

import com.example.month9onlineshop.entities.Cart;
import com.example.month9onlineshop.entities.CartItem;
import com.example.month9onlineshop.entities.Item;
import lombok.*;

@Data
@Builder(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
public class CartItemDTO {

    public static CartItemDTO from(CartItem cartItem) {
        return builder()
//                .id(cartItem.getId())
                .cart(cartItem.getCart().getId())
//                .item(cartItem.getItem().getId())
                .quantity(cartItem.getQuantity())
                .build();
    }

//    private Long id;
    private Long cart;
//    private Long item;
    private Long quantity;
}
