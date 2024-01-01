package com.example.optimization.repository;

import com.example.optimization.model.OrderPlannedProduction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderPlannedProductionRepository extends JpaRepository<OrderPlannedProduction, Long> {
}
