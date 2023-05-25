package com.example.month9onlineshop.controller;

import com.example.month9onlineshop.dto.ItemDTO;
import com.example.month9onlineshop.dto.ReviewDTO;
import com.example.month9onlineshop.entities.CartItem;
import com.example.month9onlineshop.entities.Item;
import com.example.month9onlineshop.entities.OrderedItem;
import com.example.month9onlineshop.repositories.ItemRepository;
import com.example.month9onlineshop.repositories.OrderedItemRepository;
import com.example.month9onlineshop.services.OrderService;
import com.example.month9onlineshop.services.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Controller
@RequiredArgsConstructor
@RequestMapping()
public class ReviewController {
    private final ReviewService reviewService;
    private final ItemRepository itemRepository;
    private final OrderService orderService;
    private final OrderedItemRepository orderedItemRepository;

    @GetMapping("/reviewsByItemId")
    public List<ReviewDTO> getReviewByItemId(@RequestParam Long itemId) {
        return reviewService.getReviewsByItemId(itemId)
                .stream().map(ReviewDTO::from).
                collect(Collectors.toList());
    }


    @PostMapping("/addReview")
    public String addReview(Model model,
                            @RequestParam String text,
                            @RequestParam Long itemId,
                            Authentication authentication,
                            RedirectAttributes redirectAttributes) {
        UserDetails ud = (UserDetails) authentication.getPrincipal();
        reviewService.addReview(text, itemId, ud.getUsername());

        List<Item> items = itemRepository.findAll();
        List<OrderedItem> orderedItems = orderedItemRepository.findAll();

        model.addAttribute("items", items);
        model.addAttribute("orderedItems", orderedItems);
        model.addAttribute("success-message", "review added");
        redirectAttributes.addAttribute("success", true);
        return "index";
    }
    //пользователь может добавлять отзывы только под теми продуктами, которые он купил
    //на бэке все отрабатывает праивльно, но на фронте выдает ftlh ошибку



//    @ExceptionHandler(NoSuchElementException.class)
//    public ResponseEntity<String> handleNoSuchElementException(NoSuchElementException e) {
//        return ResponseEntity.badRequest().body("error, user is not exists with this id");
//    }
}
