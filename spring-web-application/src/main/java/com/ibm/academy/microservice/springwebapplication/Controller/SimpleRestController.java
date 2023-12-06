package com.ibm.academy.microservice.springwebapplication.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@RestController
@RequestMapping("/v1/rest")
public class SimpleRestController {

    @RequestMapping(value = "/random", method = RequestMethod.GET)
    public ResponseEntity<Integer> getValueRandom(){
        Random r = new Random();
        return new ResponseEntity<>(r.nextInt(), HttpStatus.OK);
    }

    @PostMapping("/method")
    public ResponseEntity<Map<String,String>> changeMethodType(){
        Map<String, String> mapResponse = new HashMap<>();
        mapResponse.put("Campo1","Valor1");
        mapResponse.put("Campo2","Valor2");
        mapResponse.put("Campo3","Valor3");
        mapResponse.put("Campo4","Valor4");
        mapResponse.put("Campo5","Valor5");

        return new ResponseEntity<>(mapResponse,HttpStatus.OK);

    }
}
