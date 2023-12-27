package com.example.optimization.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
@Table(name = "t_order_planned_production_raw_material")
public class OrderPlannedProductionRawMaterial {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @ManyToOne
    @JoinColumn(name = "raw_material_information_id")
    RawMaterialInformation information;

    @Column(name = "quantity")
    private Double quantity;
}