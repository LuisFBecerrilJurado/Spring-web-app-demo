package com.ibm.academy.microservice.springwebapplication.service;


import com.ibm.academy.microservice.springwebapplication.model.Item;
import java.util.Arrays;
import java.util.List;


public class ItemServiceImp implements ItemService {

    private static List<Item> itemList (){
        return Arrays.asList(
                new Item(1,"Item 1","Item 1 Description", "Item-001"),
                new Item(2,"Item 2","Item 2 Description", "Item-002"),
                new Item(3,"Item 3","Item 3 Description", "Item-003"),
                new Item(4,"Item 4","Item 4 Description", "Item-004"),
                new Item(5,"Item 5","Item 5 Description", "Item-005")
        );
    }

    @Override
    public List<Item> getAllItems() {
        return null;
    }
}
