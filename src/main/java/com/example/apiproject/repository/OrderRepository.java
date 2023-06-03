package com.example.apiproject.repository;

import com.example.apiproject.access.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order,Integer> {



    List<Order> findByUsername(String Username);




}
