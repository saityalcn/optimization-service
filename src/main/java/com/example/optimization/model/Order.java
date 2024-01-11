package com.example.optimization.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.util.List;

@Entity
@Data
@Table(name = "t_order")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "order_title")
    private String orderTitle;

    @Column(name = "order_quantity")
    private Long orderQuantity;

    @ManyToOne
    @JoinColumn(name = "production_plan_id")
    private ProductionPlan productionPlan;

    @ManyToOne
    @JoinColumn(name = "order_product_id")
    private Product product;

    @Transient
    private String productionPlanName;
}
