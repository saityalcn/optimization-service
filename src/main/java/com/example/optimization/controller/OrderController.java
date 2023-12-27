package com.example.optimization.controller;

import com.example.optimization.model.Order;
import com.example.optimization.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(path = "/order")
public class OrderController {

    @Autowired
    OrderService service;
    @RequestMapping(method = RequestMethod.GET, path = "/")
    public String getIndex(){
        return "Order";
    }

    @RequestMapping(method = RequestMethod.GET, path = "/get-orders")
    public Object getOrders(){
        return service.getOrders();
    }

    @RequestMapping(method = RequestMethod.POST, path = "/create-order")
    public Order addOrder(@RequestBody Order order){
        return service.addOrder(order);
    }

}
