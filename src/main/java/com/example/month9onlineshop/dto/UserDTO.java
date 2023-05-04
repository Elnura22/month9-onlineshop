package com.example.month9onlineshop.dto;

import com.example.month9onlineshop.entities.Item;
import com.example.month9onlineshop.entities.User;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Data
@Builder(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
public class UserDTO {

    public static UserDTO from(User user) {
        return builder()
                .id(user.getId())
                .accountName(user.getAccountName())
                .email(user.getEmail())
                .build();
    }
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 128)
    private String accountName;
    @Column(length = 128)
    private String email;
}
