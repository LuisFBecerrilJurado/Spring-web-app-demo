package com.ibm.academy.microservice.springwebapplication.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class Item {

    @NotNull
    private Integer itemId;

    @NotNull
    @NotBlank
    private String itemName;

    @NotNull
    private String itemDescription;

    @NotNull
    @NotBlank
    private String itemNumber;


    public Item() {
    }

    public Item(Integer itemId, String itemName, String itemDescription, String itemNumber) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.itemDescription = itemDescription;
        this.itemNumber = itemNumber;
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    public String getItemNumber() {
        return itemNumber;
    }

    public void setItemNumber(String itemNumber) {
        this.itemNumber = itemNumber;
    }
}
