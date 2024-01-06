package com.example.optimization.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "t_method")
public class Method {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "optimization_algorithm_key")
    private String optimizationAlgorithmKey;

    @Column(name = "regression_model_key")
    private String regressionModelKey;

    @Column(name = "operations_research_method_key")
    private String operationsResearchMethodKey;

}
