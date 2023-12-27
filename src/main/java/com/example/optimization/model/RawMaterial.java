package com.example.optimization.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

@Entity
@Data
@Table(name = "t_raw_material")
@ToString
public class RawMaterial {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "raw_material_information_id")
    RawMaterialInformation information;

    @Column(name = "cost")
    private Long cost;

    @Column(name = "quantity")
    private Long quantity;

    @JsonIgnore
    @ToString.Exclude
    @ManyToOne
    @JoinColumn(name = "production_plan_id")
    ProductionPlan productionPlan;
}

