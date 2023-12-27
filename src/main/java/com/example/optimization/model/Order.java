package com.example.optimization.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

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
    @JsonIgnore
    @JoinColumn(name = "order_id")
    private ProductionPlan productionPlan;

    @ManyToOne
    @JoinColumn(name = "order_product_id")
    private Product product;

}
