package com.example.optimization.controller;

import com.example.optimization.model.ProductionPlan;
import com.example.optimization.model.RawMaterial;
import com.example.optimization.service.ProductionPlanService;
import com.example.optimization.service.RawMaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(path = "/productionPlan")
public class ProductionPlanController {
    @Autowired
    ProductionPlanService service;

    @RequestMapping(method = RequestMethod.GET, path = "/")
    public String getIndex(){
        return "ProductionPlan";
    }

    @RequestMapping(method = RequestMethod.GET, path = "/getProductionPlans")
    public List<ProductionPlan> getProductionPlans(){
        return service.getProductionPlans();
    }

    @RequestMapping(method = RequestMethod.POST, path = "/createProductionPlan")
    public ProductionPlan addProductionPlan(@RequestBody ProductionPlan productionPlan){
        return service.addProductionPlan(productionPlan);
    }

    @RequestMapping(method = RequestMethod.POST, path = "/saveOptimizedProduction")
    public void saveOptimizedProduction(@RequestBody Long id){
        service.saveOptimizedProduction(id);
    }

}