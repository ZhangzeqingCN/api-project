package com.example.apiproject.repository;



import com.example.delombok.access.Order;
import com.example.delombok.access.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order,Integer> {

    List<Order> findByUser(User user);
}
