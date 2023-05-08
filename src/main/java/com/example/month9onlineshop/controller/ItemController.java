package com.example.month9onlineshop.controller;

import com.example.month9onlineshop.entities.Item;
import com.example.month9onlineshop.services.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/items")
public class ItemController {

    private final ItemService itemService;

    @GetMapping("/page/{pageNum}")
    public String viewPage(Model model,
                           @PathVariable(name = "pageNum") int pageNum,
                           @RequestParam String name) {

        Page<Item> page = itemService.searchAndShowItemsByName(name, pageNum);

        List<Item> listProducts = page.getContent();
        model.addAttribute("currentPage", pageNum);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());
        model.addAttribute("listProducts", listProducts);
        return "index";
    }
}

//    @GetMapping("/page/{pageNum}")
//    public String viewPageByCategory(Model model,
//                           @PathVariable(name = "pageNum") int pageNum,
//                                     @RequestParam String category) {
//
//        Page<Item> page = itemService.searchAndShowItemsByCategory(category, pageNum);
//
//        List<Item> listProducts = page.getContent();
//        model.addAttribute("currentPage", pageNum);
//        model.addAttribute("totalPages", page.getTotalPages());
//        model.addAttribute("totalItems", page.getTotalElements());
//        model.addAttribute("listProducts", listProducts);
//        return "index";


//    @GetMapping("/page/{pageNum}")
//    public String viewPageByPrice(Model model,
//                                     @PathVariable(name = "pageNum") int pageNum) {
//
//        Page<Item> page = itemService.searchAndShowItemsByPrice(pageNum);
//
//        List<Item> listProducts = page.getContent();
//        model.addAttribute("currentPage", pageNum);
//        model.addAttribute("totalPages", page.getTotalPages());
//        model.addAttribute("totalItems", page.getTotalElements());
//        model.addAttribute("listProducts", listProducts);
//        return "index";
//    }
//добавить поле отзывов у товара

