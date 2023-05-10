package com.example.month9onlineshop.controller;

import com.example.month9onlineshop.dto.UserDTO;
import com.example.month9onlineshop.dto.UserDTOSecond;
import com.example.month9onlineshop.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;
@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {
    final private UserService userService;

    @GetMapping("/userByEmail")
    public List<UserDTO> getUserByEmail(String email) {
        return userService.getUserByEmail(email).stream()
                .map(UserDTO::from)
                .collect(Collectors.toList());
    }

    @GetMapping("/userByAccountName")
    public List<UserDTO> getUserByAccountName(String accountName) {
        return userService.getUserByAccountName(accountName).stream()
                .map(UserDTO::from)
                .collect(Collectors.toList());
    }

    @GetMapping("/userByName")
    public List<UserDTO> getUserByName(String name) {
        return userService.getUserByName(name).stream()
                .map(UserDTO::from)
                .collect(Collectors.toList());
    }

    @GetMapping("/existUser/{email}")
    public ResponseEntity<Boolean> userExistsByEmail(@PathVariable String email) {
        boolean userExists = userService.existsUserByEmail(email);
        return ResponseEntity.ok(userExists);
    }

    @GetMapping("/all")
    public List<UserDTO> getAllUsers() {
        return userService.getAllUsers().stream()
                .map(UserDTO::from)
                .collect(Collectors.toList());
    }

    //register

    //login
    @PostMapping("/register")
    public ResponseEntity<UserDTO> registerNewUser(@Valid @RequestBody UserDTOSecond userDTOSecond) {
//        UserDTO userDTO = UserDTO.builder()
//                .name(userDTOSecond.getName())
//                .accountName(userDTOSecond.getAccountName())
//                .email(userDTOSecond.getEmail())
//                .
//            .build();

        if (userService.userExists(userDTOSecond.getEmail())) {
            return ResponseEntity.badRequest().build();
        } else return ResponseEntity.ok((userService.registerNewUser(userDTOSecond)));
    }

}
