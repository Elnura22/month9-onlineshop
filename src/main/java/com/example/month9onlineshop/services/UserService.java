package com.example.month9onlineshop.services;

import com.example.month9onlineshop.entities.User;
import com.example.month9onlineshop.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserService {
    final private UserRepository userRepository;

    public User save(String name, String email, String password) {
        User user = User.builder()
                .id(1L)
                .email(email)
                .accountName(name)
                .password(password)
                .build();
        return userRepository.save(user);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
