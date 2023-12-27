package com.example.optimization.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.util.Date;
import java.util.List;

@Entity
@Data
@Table(name = "t_production_plan")
public class ProductionPlan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "start_date")
    private Date startDate;

    @Column(name = "end_date")
    private Date endDate;

    @ToString.Exclude
    @OneToMany(mappedBy = "productionPlan")
    private List<RawMaterial> rawMaterials;
    
    @ToString.Exclude
    @OneToMany(mappedBy = "productionPlan")
    private List<Order> orders;

    @ToString.Exclude
    @OneToMany
    @JoinColumn(name = "production_plan_id")
    private List<OrderPlannedProduction> plannedProductionList;

}

