package com.example.apiproject.repository;


import com.example.apiproject.access.Category;
import com.example.apiproject.access.Commodity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommodityRepository extends JpaRepository<Commodity, Integer> {
    List<Commodity> findByPrice(Float price);


    List<Commodity> findByCommodityNameLike(String CommodityName);


    List<Commodity> findByCategory(Category category);
}
