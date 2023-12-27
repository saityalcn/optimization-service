package com.example.optimization.service;

import com.example.optimization.model.Product;
import com.example.optimization.model.RawMaterial;
import com.example.optimization.repository.ProductRepository;
import com.example.optimization.repository.RawMaterialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RawMaterialService {
    @Autowired
    RawMaterialRepository repository;

    public List<RawMaterial> getRawMaterials(){
        return repository.findAll();
    }

    public RawMaterial addRawMaterial(RawMaterial rawMaterial){
        return repository.save(rawMaterial);
    }
}
