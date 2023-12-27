package com.example.optimization.controller;

import com.example.optimization.model.RawMaterial;
import com.example.optimization.model.RawMaterialInformation;
import com.example.optimization.service.RawMaterialInformationService;
import com.example.optimization.service.RawMaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(path = "/rawMaterialInformation")
public class RawMaterialInformationController {
    @Autowired
    RawMaterialInformationService service;

    @RequestMapping(method = RequestMethod.GET, path = "/")
    public String getIndex(){
        return "Raw Material Informations";
    }

    @RequestMapping(method = RequestMethod.GET, path = "/getRawMaterialInformations")
    public List<RawMaterialInformation> getRawMaterialInformations(){
        return service.getRawMaterialInformations();
    }

}
