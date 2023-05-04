package com.example.month9onlineshop.services;

import com.example.month9onlineshop.dto.ItemDTO;
import com.example.month9onlineshop.entities.Item;
import com.example.month9onlineshop.exceptions.ResourceNotFoundException;
import com.example.month9onlineshop.repositories.ItemRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ItemService {
    final private ItemRepository itemRepository;
    public ItemDTO findItemByName(String name){
        Item item = itemRepository.findAllByName(name);
        if (item ==null){
            throw new ResourceNotFoundException("Can't find item with this name: " + name);
        }
        return ItemDTO.from(item);
    }

    public ItemDTO findItemByCategory(String category){
        Item item = itemRepository.findAllByCategory(category);
        if (item ==null){
            throw new ResourceNotFoundException("Can't find item with this category: " + category);
        }
        return ItemDTO.from(item);
    }

    public ItemDTO findItemByPrice(Long price){
        Item item = itemRepository.findAllByPrice(price);
        if (item ==null){
            throw new ResourceNotFoundException("Can't find item with this price: " + price);
        }
        return ItemDTO.from(item);
    }


}
