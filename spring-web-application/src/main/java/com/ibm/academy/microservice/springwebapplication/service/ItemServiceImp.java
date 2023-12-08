package com.ibm.academy.microservice.springwebapplication.service;


import com.ibm.academy.microservice.springwebapplication.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class ItemServiceImp implements ItemService {

    static List<Item> itemList;

    public ItemServiceImp() {
        itemList = new ArrayList<>(
                Arrays.asList(
                        new Item(1,"Item 1","Item 1 Description", "Item-001"),
                        new Item(2,"Item 2","Item 2 Description", "Item-002"),
                        new Item(3,"Item 3","Item 3 Description", "Item-003"),
                        new Item(4,"Item 4","Item 4 Description", "Item-004"),
                        new Item(5,"Item 5","Item 5 Description", "Item-005")
                )
        );
    }

    private static List<Item> itemList (){
        return itemList;
    }

    @Override
    public List<Item> getAllItems() {
        return itemList();
    }

    @Override
    public Item getItemById(Integer itemId) {
        return itemList().stream().
                filter(item -> item.getItemId().equals(itemId))
                .findFirst()
                .orElse(null);
    }

    @Override
    public void createItem(Item item) {
        itemList.add(item);
    }
}
