package com.example.optimization.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "t_product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "strength_min")
    private Long strengthMin;

    @Column(name = "strength_max")
    private Long strengthMax;

}
