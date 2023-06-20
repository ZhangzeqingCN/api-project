package com.example.apiproject.repository;

import com.example.delombok.access.Order;
import com.example.delombok.access.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderDetailRepository extends JpaRepository<OrderDetail,Integer> {

    List<OrderDetail> findByOrder(Order order);
}
