package com.example.optimization.service;

import com.example.optimization.client.AlgorithmClient;
import com.example.optimization.dto.OrderDTO;
import com.example.optimization.model.Order;
import com.example.optimization.repository.OrderRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService {
    @Autowired
    private OrderRepository repository;


    private ModelMapper modelMapper = new ModelMapper();


    public List<OrderDTO> getOrders(){
        return repository.findAll().stream().map(e -> {e.setProductionPlanName(e.getProductionPlan().getTitle());  return modelMapper.map(e, OrderDTO.class);}).collect(Collectors.toList());
    }

    public Order addOrder(Order order){
        return repository.save(order);
    }

}
