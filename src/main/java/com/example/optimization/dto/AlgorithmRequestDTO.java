package com.example.optimization.dto;

import com.example.optimization.model.Order;
import jakarta.persistence.Entity;
import lombok.Data;

import java.util.HashMap;
import java.util.List;

@Data
public class AlgorithmRequestDTO {

    private List<HashMap<String, Long>> orders;
    private HashMap<String, Long> rawMaterials;

}
