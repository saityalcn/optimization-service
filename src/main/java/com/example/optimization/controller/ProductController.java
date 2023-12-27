package com.example.optimization.controller;

import com.example.optimization.model.Order;
import com.example.optimization.model.Product;
import com.example.optimization.service.OrderService;
import com.example.optimization.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(path = "/product")
public class ProductController {

    @Autowired
    ProductService service;

    @RequestMapping(method = RequestMethod.GET, path = "/")
    public String getIndex(){
        return "Product";
    }

    @RequestMapping(method = RequestMethod.GET, path = "/get-products")
    public List<Product> getProducts(){
        return service.getProducts();
    }

    @RequestMapping(method = RequestMethod.POST, path = "/create-product")
    public Product addProduct(@RequestBody Product product){
        return service.addProduct(product);
    }
}