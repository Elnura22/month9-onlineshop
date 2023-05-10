package com.example.month9onlineshop.dto;

import com.example.month9onlineshop.entities.Cart;
import com.example.month9onlineshop.entities.Item;
import lombok.*;

@Data
@Builder(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
public class CartItemDTO {

//    public static CartItemDTO from(Cart cart) {
//        return builder()
//                .id(cart.getId())
//                .cart(cart.get)
//                .itemId(cart())
//                .userId(cart.getUserId())
//                .itemId(cart.getItemId())
//                .build();
//    }

    private Long id;
    private Cart cart;
    private Item itemId;
    private Long quantity;
}
