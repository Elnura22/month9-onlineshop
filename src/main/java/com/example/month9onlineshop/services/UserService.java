package com.example.month9onlineshop.services;

import com.example.month9onlineshop.dto.UserDTO;
import com.example.month9onlineshop.entities.User;
import com.example.month9onlineshop.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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


    public UserDTO findUser(String user) {
        var users = userRepository.findAll();
        for (User userThis : users){
            if (userThis.getEmail().equalsIgnoreCase(user)){
                return UserDTO.from(userThis);
            }
        }
        return null;
    }
}
