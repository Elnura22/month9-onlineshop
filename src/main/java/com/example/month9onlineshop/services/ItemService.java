package com.example.month9onlineshop.services;

import com.example.month9onlineshop.entities.Item;
import com.example.month9onlineshop.repositories.ItemRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class ItemService {
    final private ItemRepository itemRepository;

    public Page<Item> searchAndShowItemsByName(String name,Integer pageNum) {
        int pageSize = 5;
        Pageable pageable = PageRequest.of(pageNum - 1, pageSize);
        return itemRepository.findAllByName(name,pageable);
    }

    public Page<Item> searchAndShowItemsByCategory(String category, Integer pageNum) {
        int pageSize = 5;
        Pageable pageable = PageRequest.of(pageNum - 1, pageSize);
        return itemRepository.findAllByCategory(category, pageable);
    }

    public Page<Item> searchAndShowItemsByPrice(Long price,Integer pageNum) {
        int pageSize = 5;
        Pageable pageable = PageRequest.of(pageNum - 1, pageSize);
        return itemRepository.findAllByPrice(price, pageable);
    }


//        List<Item> allProductsSecond =
//               itemRepository.findAllByName(pageable);
//
//
//        if (name != null) {
//         return itemRepository.findAllByName(pageable);
//        }  else {
//        return  itemRepository.findAll(pageable).getContent();
//        }
//        return itemRepository.findAll(pageable);


//    public ItemDTO findItemByName(String name){
//        Item item = itemRepository.findAllByName(name);
//        if (item ==null){
//            throw new ResourceNotFoundException("Can't find item with this name: " + name);
//        }
//        return ItemDTO.from(item);
//    }

//    public ItemDTO findItemByCategory(String category){
//        Item item = itemRepository.findAllByCategory(category);
//        if (item ==null){
//            throw new ResourceNotFoundException("Can't find item with this category: " + category);
//        }
//        return ItemDTO.from(item);
//    }
//
//    public ItemDTO findItemByPrice(Long price){
//        Item item = itemRepository.findAllByPrice(price);
//        if (item ==null){
//            throw new ResourceNotFoundException("Can't find item with this price: " + price);
//        }
//        return ItemDTO.from(item);
//    }


}
