package com.example.optimization.service;

import com.example.optimization.model.RawMaterial;
import com.example.optimization.model.RawMaterialInformation;
import com.example.optimization.repository.RawMaterialInformationRepository;
import com.example.optimization.repository.RawMaterialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RawMaterialInformationService {
    @Autowired
    RawMaterialInformationRepository repository;

    public List<RawMaterialInformation> getRawMaterialInformations(){
        return repository.findAll();
    }

    public RawMaterialInformation getByMaterialName(String materialName){
        return repository.findByMaterialName(materialName);
    }

}
