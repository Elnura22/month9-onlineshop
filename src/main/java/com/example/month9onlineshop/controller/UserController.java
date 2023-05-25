package com.example.month9onlineshop.controller;

import com.example.month9onlineshop.dto.UserDTO;
import com.example.month9onlineshop.dto.UserDTOSecond;
import com.example.month9onlineshop.entities.User;
import com.example.month9onlineshop.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.Banner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Validated

@Controller
@RequiredArgsConstructor
@RequestMapping()
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

    @GetMapping("/register")
    public String registerGet() {
        return "register";
    }


    @PostMapping(path = "/register")
    public String registerPost(@Valid UserDTOSecond userDTOSecond) {
        userService.createUser(userDTOSecond);
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String loginGet() {
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String email,
                        @RequestParam String password,
                        Model model) {
        User user = userService.findUserByEmail(email);
        if (user == null || !userService.checkUserForLogin(user.getEmail(), password)) {
            model.addAttribute("errorMessage", "Invalid email or password. Please try again.");
            return "login";
        }
        return "redirect:/items-list?name=t-shirt&page=0";
    }


    @PostMapping(path = "/restore")
    public String restorePassword(Model model,
                                  @RequestParam(value = "email") String email) {
        User user = userService.findUserByEmail(email);
        if (user == null) {
            model.addAttribute("errorMessage", "User not found");
            return "restore";
        }
        String randomToken = UUID.randomUUID().toString();
        userService.saveTokenLikePassword(email, randomToken);
        model.addAttribute("randomToken", randomToken);
        return "pageWithToken";
    }

    @GetMapping(path = "/restore")
    public String showPageRestore() {
        return "restore";
    }

    @PostMapping("/resetPass")
    public String changeNewPassword(@RequestParam("token") String token,
                                    @RequestParam("password") String newPassword,
                                    @RequestParam String email,
                                    Model model) {
        userService.saveNewPassword(email, token, newPassword);
        model.addAttribute("resetToken", token);
        return "redirect:/login";
    }



}
