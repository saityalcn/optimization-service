package com.example.optimization.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class AlgorithmClient {

    private final RestTemplate restTemplate;
    private final String apiUrl = "http://localhost:5000/";

    @Autowired
    public AlgorithmClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Object postOptimizationModel(){
        ResponseEntity<Object> response = restTemplate.getForEntity(apiUrl + "/optimization", Object.class);
        return response.getBody();
    }
}
