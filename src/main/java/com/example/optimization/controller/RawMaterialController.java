package com.example.optimization.controller;

import com.example.optimization.model.Product;
import com.example.optimization.model.RawMaterial;
import com.example.optimization.service.ProductService;
import com.example.optimization.service.RawMaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(path = "/rawMaterial")
public class RawMaterialController {
    @Autowired
    RawMaterialService service;

    @RequestMapping(method = RequestMethod.GET, path = "/")
    public String getIndex(){
        return "Product";
    }

    @RequestMapping(method = RequestMethod.GET, path = "/getRawMaterials")
    public List<RawMaterial> getRawMaterials(){
        return service.getRawMaterials();
    }

    @RequestMapping(method = RequestMethod.POST, path = "/createRawMaterial")
    public RawMaterial addRawMaterial(@RequestBody RawMaterial rawMaterial){
        return service.addRawMaterial(rawMaterial);
    }
}
