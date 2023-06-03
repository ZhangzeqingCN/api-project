package com.example.apiproject.repository;

import com.example.apiproject.access.Commodity;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.util.List;

public interface CommodityRepository extends JpaRepository<Commodity, Integer> {
    List<Commodity> findByPrice(Float price);


    Commodity findByCommodityName(String CommodityName);
}
