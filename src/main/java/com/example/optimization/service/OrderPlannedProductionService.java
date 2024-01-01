package com.example.optimization.service;

import com.example.optimization.model.Order;
import com.example.optimization.model.OrderPlannedProduction;
import com.example.optimization.repository.OrderPlannedProductionRepository;
import com.example.optimization.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderPlannedProductionService {
    @Autowired
    private OrderPlannedProductionRepository repository;


    public List<OrderPlannedProduction> addAll(List<OrderPlannedProduction> list){
        return repository.saveAll(list);
    }
}
