package com.example.month9onlineshop.dto;

import com.example.month9onlineshop.entities.User;
import lombok.*;

@Data
@Builder(access = AccessLevel.PUBLIC)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
public class UserDTO {

    public static UserDTO from(User user) {
        return builder()
                .id(user.getId())
                .name(user.getName())
                .accountName(user.getAccountName())
                .email(user.getEmail())
                .build();
    }
    private Long id;
    private String name;
    private String accountName;
    private String email;
}
