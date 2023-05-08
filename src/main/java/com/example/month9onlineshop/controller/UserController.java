package com.example.month9onlineshop.controller;

import com.example.month9onlineshop.dto.UserDTO;
import com.example.month9onlineshop.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {
   final private UserService userService;

    @GetMapping("/userByEmail")
    public List<UserDTO> getUserByEmail(String email){
        return userService.getUserByEmail(email).stream()
                .map(UserDTO::from)
                .collect(Collectors.toList());
    }

    @GetMapping("/userByAccountName")
    public List<UserDTO> getUserByAccountName(String accountName){
        return userService.getUserByAccountName(accountName).stream()
                .map(UserDTO::from)
                .collect(Collectors.toList());
    }

    @GetMapping("/userByName")
    public List<UserDTO> getUserByName(String name){
        return userService.getUserByName(name).stream()
                .map(UserDTO::from)
                .collect(Collectors.toList());
    }

    //register

    //login

//    @GetMapping("/allPosts")
//    public ResponseEntity<List<UserDTO>> getAllPublications(){
//        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
//    }

//    @GetMapping("/userByName")
//    public ResponseEntity<List<UserDTO>> userByName(@RequestParam String name) {
//        return new ResponseEntity<>(userService.findByName(name), HttpStatus.OK);
//    }



//    @GetMapping("/userByEmail")
//    public ResponseEntity<List<UserDTO>> userByEmail(@RequestParam String email) {
//        return new ResponseEntity<>(userService.findByEmail(email), HttpStatus.OK);
//    }
//
//
//    @GetMapping("/userByAccountName")
//    public ResponseEntity<List<UserDTO>> userByAccount(@RequestParam String accountName) {
//        return new ResponseEntity<>(userService.findByAccountName(accountName), HttpStatus.OK);
//    }


    //Поиск пользователей:
    //
    //По имени;
    //
    //Имени учетной записи;
    //
    //Адресу почты;
}
