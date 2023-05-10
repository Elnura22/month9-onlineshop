package com.example.month9onlineshop.dto;

import com.example.month9onlineshop.entities.Cart;
import com.example.month9onlineshop.entities.User;
import lombok.*;

@Data
@Builder(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
public class CartDTO {
    public static CartDTO from(Cart cart) {
        return builder()
                .id(cart.getId())
                .userId(cart.getUserId())
//                .itemId(cart.getItemId())
                .build();
    }


    private Long id;
    private User userId;
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "item_id")
//    private Item itemId;
}
