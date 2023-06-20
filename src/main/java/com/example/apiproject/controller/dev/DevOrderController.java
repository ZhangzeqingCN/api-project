package com.example.apiproject.controller.dev;


import com.example.delombok.access.Order;
import com.example.delombok.access.User;
import com.example.delombok.domain.Result;
import com.example.delombok.repository.OrderRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/dev/order")
@Slf4j
public class DevOrderController {
    @Autowired
    private OrderRepository orderRepository;

    //查看所有订单
    @GetMapping("/all")
    public Result all() {
        return Result.success(orderRepository.findAll());
    }
    //根据用户查看订单
    @GetMapping("/user")
    public Result findByUser(@RequestBody User user) {
        return Result.success(orderRepository.findByUser(user));
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

    //删除订单，如果有详细订单则删除失败
    @DeleteMapping
    public Result deleteOrderById(@RequestParam Integer orderId){
        try {
            orderRepository.deleteById(orderId);
            return Result.success();
        }catch (Exception e){
            return Result.error(e.getMessage()).addErrors(e);
        }
    }

    //添加订单
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
