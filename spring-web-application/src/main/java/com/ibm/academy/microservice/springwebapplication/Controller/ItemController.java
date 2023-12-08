package com.ibm.academy.microservice.springwebapplication.Controller;

import com.ibm.academy.microservice.springwebapplication.model.Item;
import com.ibm.academy.microservice.springwebapplication.service.ItemService;
import com.ibm.academy.microservice.springwebapplication.service.ItemServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.ConditionalOnRepositoryType;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/v1/item")
public class ItemController {

    @Autowired
    ItemServiceImp itemService;
    @GetMapping("/")
    public ResponseEntity<List<Item>> getAllItems(@RequestHeader String uuid){
        //Validacion
        System.out.printf("Header Request uui -->{%s}",uuid);
        //Capa Servicio
        List<Item> itemList = itemService.getAllItems();
        //Regresar Mensaje
        HttpHeaders headers = new HttpHeaders();
        headers.add("uuid",uuid);
        headers.add("ControllerService", ItemController.class.getName());
        return new ResponseEntity<>(itemList,headers,HttpStatus.OK);
    }

    @GetMapping("/getItem")
    public ResponseEntity<Object> getItemByItemId(@RequestParam(name = "item_id") Integer itemId){
        //Validacion
        System.out.printf("Param Request id -->{%s}",itemId);
        //Servicio
        Item item = itemService.getItemById(itemId);
        //Mensaje
        if(item == null){
            String sb = "Item con el id: " + itemId + " no se encuentra en la lista";
            return new ResponseEntity<>(sb,HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(item,HttpStatus.OK);
    }

    @GetMapping("/{itemId}")
    public ResponseEntity<Object> getItemByPathItemId(@PathVariable Integer itemId){
        //Validacion
        System.out.printf("Param Request id -->{%s}",itemId);
        //Servicio
        Item item = itemService.getItemById(itemId);
        //Mensaje
        if(item == null){
            String sb = "Item con el id: " + itemId + " no se encuentra en la lista";
            return new ResponseEntity<>(sb,HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(item,HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<Object> createItem(@RequestBody Item item){
        //Validacion

        //Servicio
        itemService.createItem(item);

        //Mensaje
        return new ResponseEntity<>(item,HttpStatus.CREATED);
    }
}
