package com.example.apiproject.controller.dev;

import com.example.apiproject.access.Order;
import com.example.apiproject.domain.Result;
import com.example.apiproject.repository.OrderRepository;
import com.example.apiproject.repository.OrderRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/dev/order")
@Slf4j
public class DevOrderController {
    @Autowired
    private OrderRepository orderRepository;


    @GetMapping("/all")
    public Result all() {
        return Result.success(orderRepository.findAll());
    }

    @PutMapping
    public Result updateOrder(@RequestBody Order order){
        try {
            orderRepository.save(order);
            return Result.success();
        } catch (Exception e) {
            return Result.error(e.getMessage()).addErrors(e);
        }
    }

    @DeleteMapping
    public Result deleteOrderById(@RequestParam Integer orderId){
        try {
            orderRepository.deleteById(orderId);
            return Result.success();
        }catch (Exception e){
            return Result.error(e.getMessage()).addErrors(e);
        }
    }


    @PostMapping
    public Result addOrder(@RequestBody Order order){
        try {
            orderRepository.save(order);
            return Result.success();
        } catch (Exception e) {
            return Result.error(e.getMessage()).addErrors(e);
        }
    }
}
