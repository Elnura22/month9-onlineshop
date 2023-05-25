package com.example.month9onlineshop.controller;

import com.example.month9onlineshop.dto.CartItemDTO;
import com.example.month9onlineshop.entities.CartItem;
import com.example.month9onlineshop.repositories.CartItemRepository;
import com.example.month9onlineshop.services.CartItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Controller
@RequiredArgsConstructor
//@SessionAttributes(value = "shoppingCart")
//@RequestMapping("cartItems")
public class CartItemController {
    private final CartItemService cartItemService;

    @GetMapping("/byCartId")
    public List<CartItemDTO> getCartItemsByCart(@RequestParam Long cartId) {
        return cartItemService.getAllCartItemsByCart(cartId)
                .stream().map(CartItemDTO::from)
                .collect(Collectors.toList());
    }

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<String> handleNoSuchElementException(NoSuchElementException e) {
        return ResponseEntity.badRequest().body("User is not exists with this id");
    }



    @PostMapping("/cart")
    public String add(@RequestParam(value = "itemId", required = false) Long id,
                      Authentication authentication,
                      HttpSession session) {
        if (authentication == null || !authentication.isAuthenticated()) {
            return "redirect:/login";
        }
        UserDetails ud = (UserDetails) authentication.getPrincipal();
        cartItemService.addToCart(id, ud.getUsername());
        List<CartItem> items = cartItemService.showItemsByCart(ud.getUsername());
        session.setAttribute("items", items);
        return "cartForOnePerson";
    }

    @GetMapping("/myCart")
    public String addGet(Model model,
                         Authentication authentication) {
        if (authentication == null || !authentication.isAuthenticated()) {
            return "redirect:/login";
        }
        UserDetails ud = (UserDetails) authentication.getPrincipal();
        model.addAttribute("items", cartItemService.showItemsByCart(ud.getUsername()));
        return "showMyCart";
    }


    @PostMapping("/deleteItemFromCart")
    public String deleteItemFromCart(@RequestParam("itemId") Long itemId,
                                     Authentication authentication) {
        if (authentication == null || !authentication.isAuthenticated()) {
            return "redirect:/login";
        }
        UserDetails ud = (UserDetails) authentication.getPrincipal();
        cartItemService.deleteItemFromCart(itemId, ud.getUsername());
        return "redirect:/myCart";
    }


    @PostMapping("/updateQuantity")
    public String updateCartItemQuantity(@RequestParam("cartItemId") Long cartItemId,
                                         @RequestParam("quantity") Long quantity) {
        cartItemService.updateQuantity(cartItemId, quantity);
        return "redirect:/myCart";
    }

}



