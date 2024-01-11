package com.example.optimization.dto;

import com.example.optimization.model.ProductionPlan;
import com.example.optimization.model.RawMaterialInformation;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

@Data
public class RawMaterialDTO {

    private Long id;

    private RawMaterialInformation information;

    private Long cost;

    private Long quantity;

    private String productionPlanName;
}
