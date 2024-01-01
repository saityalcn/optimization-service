package com.example.optimization.controller;

import com.example.optimization.model.RawMaterial;
import com.example.optimization.model.User;
import com.example.optimization.service.RawMaterialService;
import com.example.optimization.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(path = "/user")
public class UserController {
    @Autowired
    UserService service;

    @RequestMapping(method = RequestMethod.GET, path = "/")
    public String getIndex(){
        return "Product";
    }

    @RequestMapping(method = RequestMethod.GET, path = "/getUsers")
    public List<User> getUsers(){
        return service.getAll();
    }

    @RequestMapping(method = RequestMethod.POST, path = "/register")
    public User registerUser(@RequestBody HashMap<String, String> map){
        return service.registerUser(map.get("email"), map.get("password"));
    }

    @RequestMapping(method = RequestMethod.POST, path = "/login")
    public User login(@RequestBody HashMap<String, String> map){
        return service.authenticateUser(map.get("email"), map.get("password"));
    }

    /*

    @RequestMapping(method = RequestMethod.POST, path = "/createRawMaterial")
    public RawMaterial addRawMaterial(@RequestBody RawMaterial rawMaterial){
        return serviceUs.addRawMaterial(rawMaterial);
    }

    */
}
