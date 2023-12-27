package com.example.optimization.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "t_raw_material_information")
public class RawMaterialInformation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "material_name")
    private String materialName;

}

