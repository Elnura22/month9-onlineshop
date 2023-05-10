package com.example.month9onlineshop.services;

import com.example.month9onlineshop.dto.UserDTO;
import com.example.month9onlineshop.dto.UserDTOSecond;
import com.example.month9onlineshop.entities.User;
import com.example.month9onlineshop.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserService {
    final private UserRepository userRepository;
//    private final PasswordEncoder passwordEncoder;


    public List<User> getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public List<User> getUserByAccountName(String accountName) {
        return userRepository.findByAccountName(accountName);
    }

    public List<User> getAllUsers(){
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
//        password = passwordEncoder.encode(password);
        User user = User.builder()
                .name(userDTOSecond.getName())
                .accountName(userDTOSecond.getAccountName())
                .email(userDTOSecond.getEmail())
                .password(password)
                .build();
        userRepository.save(user);
        return UserDTO.from(user);
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
