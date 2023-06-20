package com.example.delombok.controller;

import com.example.delombok.access.Order;
import com.example.delombok.access.OrderDetail;
import com.example.delombok.domain.Result;
import com.example.delombok.repository.OrderDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orderDetail")
public class OrderDetailController {
    @Autowired
    private OrderDetailRepository orderDetailRepository;

    /**
     * 查看某个订单的所有详细订单。
     *
     * @param order 订单对象。
     * @return 包含符合条件的详细订单的结果对象。
     */
    @GetMapping("/all")
    public Result findOrderDetailByOrder(@RequestBody Order order) {
        return Result.success(orderDetailRepository.findByOrder(order));
    }

    /**
     * 更新订单详细信息。
     *
     * @param orderDetail 要更新的订单详细对象。
     * @return 更新结果的结果对象。
     */
    @PutMapping
    public Result updateOrderDetail(@RequestBody OrderDetail orderDetail){
        try {
            orderDetailRepository.save(orderDetail);
            return Result.success();
        } catch (Exception e) {
            return Result.error(e.getMessage()).addErrors(e);
        }
    }

    /**
     * 删除订单详细。
     *
     * @param orderDetailId 要删除的订单详细ID。
     * @return 删除结果的结果对象。
     */
    @DeleteMapping
    public Result deleteOrderDetailById(@RequestParam Integer orderDetailId){
        try {
            orderDetailRepository.deleteById(orderDetailId);
            return Result.success();
        }catch (Exception e){
            return Result.error(e.getMessage()).addErrors(e);
        }
    }

    /**
     * 增加订单详细信息。
     *
     * @param orderDetail 要添加的订单详细对象。
     * @return 添加结果的结果对象。
     */
    @PostMapping
    public Result addOrderDetail(@RequestBody OrderDetail orderDetail){
        try {
            orderDetailRepository.save(orderDetail);
            return Result.success();
        } catch (Exception e) {
            return Result.error(e.getMessage()).addErrors(e);
        }
    }
}
