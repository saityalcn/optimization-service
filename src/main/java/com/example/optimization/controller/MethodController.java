package com.example.optimization.controller;

import com.example.optimization.model.Method;
import com.example.optimization.model.Product;
import com.example.optimization.service.MethodService;
import com.example.optimization.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(path = "/method")
public class MethodController {

    @Autowired
    MethodService service;

    @RequestMapping(method = RequestMethod.GET, path = "/get-methods")
    public List<Method> getAllMethods(){
        return service.getAllMethods();
    }

}
