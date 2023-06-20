package com.example.apiproject.repository;


import com.example.delombok.access.ShoppingCart;
import com.example.delombok.access.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ShoppingCartRepository extends JpaRepository<ShoppingCart,Integer> {


    //通过用户查询购物车
    List<ShoppingCart> findShoppingCartByUser(User user);

}
