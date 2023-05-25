package com.example.month9onlineshop.services;

import com.example.month9onlineshop.entities.*;
import com.example.month9onlineshop.repositories.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class ReviewService {
    private final ReviewRepository reviewRepository;
    private final ItemRepository itemRepository;
    private final UserRepository userRepository;
    private final CartRepository cartRepository;
    private final CartItemRepository cartItemRepository;
    private final OrderRepository orderRepository;
    private final OrderedItemRepository orderedItemRepository;

    public List<Review> getReviewsByItemId(Long itemId) {
        Item item = itemRepository.findById(itemId).orElseThrow();
        return reviewRepository.findAllByItem(item);
    }

    public void addReview(String text, Long itemId, String email) {
        User user = userRepository.getByEmail(email).orElseThrow();
        Item item = itemRepository.findById(itemId).orElseThrow();

        List<Order> orders = orderRepository.findAllByUser(user);
        for (Order order : orders) {
            List<OrderedItem> list = orderedItemRepository.findAllByItemAndOrder(item, order);
            if (!list.isEmpty()) {
                Review review = Review.builder()
                        .text(text)
                        .date(LocalDateTime.now())
                        .item(item)
                        .user(user)
                        .build();
                reviewRepository.save(review);
            }
        }
    }

}


