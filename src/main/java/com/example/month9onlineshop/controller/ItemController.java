package com.example.month9onlineshop.controller;

import com.example.month9onlineshop.dto.ItemDTO;
import com.example.month9onlineshop.services.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

//@RestController
@Controller
@RequiredArgsConstructor
@RequestMapping("/items-list")
public class ItemController {

    private final ItemService itemService;

    @GetMapping()
    public String searchItems(Model model,
                              @RequestParam(value = "name") String name,
                              @RequestParam("page") int page) {

        Page<ItemDTO> items = itemService.searchBy(name, page);
        model.addAttribute("items", items);
        model.addAttribute("page", items.getPageable());
        model.addAttribute("pageLast", items.hasNext());

        return "index";
    }

    @GetMapping("mainSearch")
    public String mainSearch() {
        return "mainSearch";
    }


}


