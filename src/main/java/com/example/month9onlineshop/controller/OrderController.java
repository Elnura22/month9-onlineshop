package com.example.month9onlineshop.controller;

import com.example.month9onlineshop.dto.CartItemDTO;
import com.example.month9onlineshop.dto.OrderDTO;
import com.example.month9onlineshop.entities.Cart;
import com.example.month9onlineshop.entities.CartItem;
import com.example.month9onlineshop.entities.Order;
import com.example.month9onlineshop.repositories.CartRepository;
import com.example.month9onlineshop.repositories.OrderRepository;
import com.example.month9onlineshop.services.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Controller
@RequiredArgsConstructor
@RequestMapping()
public class OrderController {

    private final OrderService orderService;
    private final CartRepository cartRepository;

//    @GetMapping("/ordersByUserId")
//    public List<OrderDTO> getOrdersByUserId(@RequestParam Long userId) {
//        return orderService.getOrderByUser(userId)
//                .stream().map(OrderDTO::from).
//                collect(Collectors.toList());
//    }

    @PostMapping("/makeOrder")
    public String makeOrder(Model model,
//                      @RequestParam(value = "cartId", required = false) Long cartId,
                            @RequestParam(value = "address") String address,
                            @RequestParam(value = "postIndex") Long postIndex,
                            Authentication authentication) {
        if (authentication == null || !authentication.isAuthenticated()) {
            return "showMyCart";
        }

        UserDetails ud = (UserDetails) authentication.getPrincipal();
        orderService.makeOrder(ud.getUsername(), address, postIndex);
        List<Order> orders = orderService.showOrdersByCart(ud.getUsername());
        model.addAttribute("orders", orders);
        return "redirect:/items-list?name=t-shirt&page=0";
    }


    @GetMapping("/startOrder")
    public String orderGet() {
        return "order";
    }


    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<String> handleNoSuchElementException(NoSuchElementException e) {
        return ResponseEntity.badRequest().body("user is not exists with this id");
    }
}
