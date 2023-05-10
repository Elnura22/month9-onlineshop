package com.example.month9onlineshop.dto;

import com.example.month9onlineshop.entities.User;
import lombok.*;

@Data
@Builder(access = AccessLevel.PUBLIC)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
public class UserDTOSecond {

    public static UserDTOSecond from(User user) {
        return builder()
                .id(user.getId())
                .name(user.getName())
                .accountName(user.getAccountName())
                .email(user.getEmail())
                .password(user.getPassword())
                .build();
    }
    private Long id;
    private String name;
    private String accountName;
    private String email;
    private String password;
}
