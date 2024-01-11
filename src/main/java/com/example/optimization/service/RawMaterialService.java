package com.example.optimization.service;

import com.example.optimization.dto.RawMaterialDTO;
import com.example.optimization.model.Product;
import com.example.optimization.model.RawMaterial;
import com.example.optimization.repository.ProductRepository;
import com.example.optimization.repository.RawMaterialRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RawMaterialService {
    @Autowired
    private RawMaterialRepository repository;

    private ModelMapper modelMapper = new ModelMapper();
    public List<RawMaterialDTO> getRawMaterials(){
        return repository.findAll().stream().map(e -> {e.setProductionPlanName(e.getProductionPlan().getTitle()); return modelMapper.map(e, RawMaterialDTO.class);}).collect(Collectors.toList());
    }

    public RawMaterial addRawMaterial(RawMaterial rawMaterial){
        return repository.save(rawMaterial);
    }
}
