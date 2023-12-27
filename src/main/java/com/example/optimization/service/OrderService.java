package com.example.optimization.service;

import com.example.optimization.client.AlgorithmClient;
import com.example.optimization.model.Order;
import com.example.optimization.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderRepository repository;


    public List<Order> getOrders(){
        return repository.findAll();
    }

    public Order addOrder(Order order){
        return repository.save(order);
    }

}
