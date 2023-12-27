package com.example.optimization.repository;

import com.example.optimization.model.RawMaterialInformation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RawMaterialInformationRepository extends JpaRepository<RawMaterialInformation, Long> {

    RawMaterialInformation findByMaterialName(String materialName);
}
