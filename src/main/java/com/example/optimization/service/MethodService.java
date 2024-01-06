package com.example.optimization.service;

import com.example.optimization.model.Method;
import com.example.optimization.repository.MethodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MethodService {
    @Autowired
    MethodRepository repository;

    public List<Method> getAllMethods(){
        return repository.findAll();
    }
}
