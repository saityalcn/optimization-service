package com.example.optimization.dto;

import com.example.optimization.model.Product;
import com.example.optimization.model.ProductionPlan;
import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

@Data
public class OrderDTO {
    private Long id;

    private String orderTitle;

    private Long orderQuantity;

    private Product product;

    private String productionPlanName;
}
