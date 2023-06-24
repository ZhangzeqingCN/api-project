package com.example.apiproject.controller;

import com.example.apiproject.access.Order;
import com.example.apiproject.access.OrderDetail;
import com.example.apiproject.domain.Result;
import com.example.apiproject.repository.OrderDetailRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orderDetail")
@Tag(name = "OrderDetailController", description = "订单细节相关接口控制器")
public class OrderDetailController {
    @Autowired
    private OrderDetailRepository orderDetailRepository;

    /**
     * 查看某个订单的所有详细订单。
     *
     * @param order 订单对象。
     * @return 包含符合条件的详细订单的结果对象。
     */
    @PostMapping("/all")
    @Operation(summary = "查看某个订单的所有详细订单", description = "查看某个订单的所有详细订单")
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
    @Operation(summary = "更新订单详细信息", description = "更新订单详细信息")
    public Result updateOrderDetail(@RequestBody OrderDetail orderDetail) {
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
    @Operation(summary = "删除订单详细信息", description = "删除订单详细信息")
    public Result deleteOrderDetailById(@RequestParam Integer orderDetailId) {
        try {
            orderDetailRepository.deleteById(orderDetailId);
            return Result.success();
        } catch (Exception e) {
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
    @Operation(summary = "增加订单详细信息", description = "增加订单详细信息")
    public Result addOrderDetail(@RequestBody OrderDetail orderDetail) {
        try {
            orderDetailRepository.save(orderDetail);
            return Result.success();
        } catch (Exception e) {
            return Result.error(e.getMessage()).addErrors(e);
        }
    }
}
