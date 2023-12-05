package com.ibm.academy.microservice.springwebapplication.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class ModelAndViewController {

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String getIndex(){
        return "index.html";
    }
}
