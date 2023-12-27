package com.example.optimization.service;

import com.example.optimization.model.Order;
import com.example.optimization.model.Product;
import com.example.optimization.repository.OrderRepository;
import com.example.optimization.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    ProductRepository repository;

    public List<Product> getProducts(){
        return repository.findAll();
    }

    public Product addProduct(Product product){
        return repository.save(product);
    }

}