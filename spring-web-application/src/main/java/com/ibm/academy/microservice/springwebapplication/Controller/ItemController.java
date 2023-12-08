package com.ibm.academy.microservice.springwebapplication.Controller;

import com.ibm.academy.microservice.springwebapplication.model.Item;
import com.ibm.academy.microservice.springwebapplication.service.ItemService;
import com.ibm.academy.microservice.springwebapplication.service.ItemServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value="/v1/item")
public class ItemController {

    @Autowired
    ItemServiceImp itemService;
    @GetMapping("/")
    public ResponseEntity<List<Item>> getAllItems(@RequestHeader String uuid){
        System.out.printf("Header request uui -->{%s}",uuid);
        //Capa Servicio
        List<Item> itemList = itemService.getAllItems();
        //Regresar Mensaje
        HttpHeaders headers = new HttpHeaders();
        headers.add("uuid",uuid);
        headers.add("ControllerService", ItemController.class.getName());
        return new ResponseEntity<>(itemList,headers,HttpStatus.OK);
    }


}
