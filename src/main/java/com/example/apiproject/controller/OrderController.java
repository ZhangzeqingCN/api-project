package com.example.apiproject.controller;

import com.example.apiproject.access.Order;
import com.example.apiproject.access.User;
import com.example.apiproject.domain.Result;
import com.example.apiproject.repository.OrderRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
@Slf4j
@Tag(name = "OrderController", description = "订单相关接口控制器")
public class OrderController {
    @Autowired
    private OrderRepository orderRepository;

    /**
     * 查看所有订单。
     *
     * @return 包含所有订单的结果对象。
     */
    @GetMapping("/all")
    @Operation(summary = "查看所有订单", description = "查看所有订单")
    public Result all() {
        return Result.success(orderRepository.findAll());
    }

    /**
     * 根据用户查看订单。
     *
     * @param user 用户对象。
     * @return 包含符合条件的订单的结果对象。
     */
    @PostMapping("/user")
    @Operation(summary = "根据用户查看订单", description = "根据用户查看订单")
    public Result findByUser(@RequestBody User user) {
        return Result.success(orderRepository.findByUser(user));
    }

    /**
     * 更新订单信息。
     *
     * @param order 要更新的订单对象。
     * @return 更新结果的结果对象。
     */
    @PutMapping
    @Operation(summary = "更新订单信息", description = "更新订单信息")
    public Result updateOrder(@RequestBody Order order) {
        try {
            orderRepository.save(order);
            return Result.success();
        } catch (Exception e) {
            return Result.error(e.getMessage()).addErrors(e);
        }
    }

    /**
     * 根据订单ID删除订单。
     * 如果存在相关的详细订单，则删除失败。
     *
     * @param orderId 要删除的订单ID。
     * @return 删除结果的结果对象。
     */
    @DeleteMapping
    @Operation(summary = "根据订单ID删除订单", description = "根据订单ID删除订单")
    public Result deleteOrderById(@RequestParam @Schema(defaultValue = "123") Integer orderId) {
        try {
            orderRepository.deleteById(orderId);
            return Result.success();
        } catch (Exception e) {
            return Result.error(e.getMessage()).addErrors(e);
        }
    }

    /**
     * 添加订单。
     *
     * @param order 要添加的订单对象。
     * @return 添加结果的结果对象。
     */
    @PostMapping
    @Operation(summary = "添加订单", description = "添加订单")
    public Result addOrder(@RequestBody Order order) {
        try {
            orderRepository.save(order);
            return Result.success();
        } catch (Exception e) {
            return Result.error(e.getMessage()).addErrors(e);
        }
    }
}
