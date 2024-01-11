package com.example.optimization.dto;

import com.example.optimization.model.Order;
import com.example.optimization.model.OrderPlannedProduction;
import com.example.optimization.model.RawMaterial;
import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.util.Date;
import java.util.List;

@Data
public class ProductionPlanDTO {

    private Long id;

    private String title;

    private Date startDate;

    private Date endDate;

    private List<RawMaterialDTO> rawMaterials;

    private List<OrderDTO> orders;

    private List<OrderPlannedProduction> plannedProductionList;
}
