package com.example.month9onlineshop.services;

import com.example.month9onlineshop.dto.UserDTO;
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

    public User save(String name, String email, String password) {
        User user = User.builder()
                .id(1L)
                .email(email)
                .accountName(name)
                .password(password)
                .build();
        return userRepository.save(user);
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

    public UserDTO registerNewUser(/*UserDTO userDTO,*/
            UserDTOSecond userDTOSecond) {
        String password = userDTOSecond.getPassword();
        password = passwordEncoder.encode(password);
        User user = User.builder()
                .name(userDTOSecond.getName())
                .accountName(userDTOSecond.getAccountName())
                .email(userDTOSecond.getEmail())
                .password(password)
                .build();
        userRepository.save(user);
        return UserDTO.from(user);
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

    public void createCartForUser(Cart cart){
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


//    public UserDTO findUser(String user) {
//        var users = userRepository.findAll();
//        for (User userThis : users){
//            if (userThis.getEmail().equalsIgnoreCase(user)){
//                return UserDTO.from(userThis);
//            }
//        }
//        return null;
//    }


}
