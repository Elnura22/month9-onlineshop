package com.example.month9onlineshop.services;

import com.example.month9onlineshop.dto.UserDTOSecond;
import com.example.month9onlineshop.entities.Cart;
import com.example.month9onlineshop.entities.User;
import com.example.month9onlineshop.repositories.CartRepository;
import com.example.month9onlineshop.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.UserDetailsService;


import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService implements UserDetailsService {
    final private UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final CartRepository cartRepository;


    public List<User> getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public List<User> getUserByAccountName(String accountName) {
        return userRepository.findByAccountName(accountName);
    }

    public List<User> getAllUsers() {
        return userRepository.findAllUsers(Sort.by("name"));
    }

    public List<User> getUserByName(String name) {
        return userRepository.findByName(name);
    }


    public void saveNewPassword(String email, String token, String newPassword) {
        User user = userRepository.getByEmail(email).orElseThrow();
        if (passwordEncoder.matches(token, user.getPassword())) {
            user.setPassword(passwordEncoder.encode(newPassword));
            userRepository.save(user);
        }
    }

        public void saveTokenLikePassword(String email, String randomToken) {
        User user = userRepository.getByEmail(email).orElseThrow();
        user.setPassword(passwordEncoder.encode(randomToken));
        userRepository.save(user);
    }

    public boolean checkUserForLogin(String email, String password) {
        var list = userRepository.findAll();
        for (var user : list) {
            if (user.getEmail().equalsIgnoreCase(email) &&
                    user.getPassword().equalsIgnoreCase(password)) {
                return true;
            }
        }
        return false;
    }

    public boolean userExists(String email) {
        List<User> list = userRepository.findAll();
        for (var user : list) {
            if (user.getEmail().equalsIgnoreCase(email)) {
                return true;
            }
        }
        return false;
    }

    public boolean existsUserByEmail(String email) {
        return userRepository.existsUserByEmail(email);
    }

    public void createUser(UserDTOSecond userDto) {

        User user = User.builder()
                .name(userDto.getName())
                .accountName(userDto.getAccountName())
                .email(userDto.getEmail())
                .password(passwordEncoder.encode(userDto.getPassword()))
                .build();

        userRepository.save(user);
        createCartForUser(Cart.builder()
                .userId(user)
                .build());
    }

    public void createCartForUser(Cart cart) {
        cartRepository.save(cart);
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<User> optUser = userRepository.getByEmail(email);
        if (optUser.isEmpty()) {
            throw new UsernameNotFoundException("Not found");
        }
        return optUser.get();
    }

    public User findUserByEmail(String email) {
        return userRepository.getByEmail(email).orElseThrow();
    }

}
