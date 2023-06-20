package com.example.delombok.repository;


import com.example.delombok.access.Category;
import com.example.delombok.access.Commodity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommodityRepository extends JpaRepository<Commodity, Integer> {
    List<Commodity> findByPrice(Float price);


    List<Commodity> findByCommodityNameLike(String CommodityName);


    List<Commodity> findByCategory(Category category);
}
