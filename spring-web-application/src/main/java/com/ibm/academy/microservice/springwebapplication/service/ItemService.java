package com.ibm.academy.microservice.springwebapplication.service;

import com.ibm.academy.microservice.springwebapplication.model.Item;

import java.util.List;

public interface ItemService {
    public List<Item> getAllItems ();
    public Item getItemById(Integer itemId);
}
