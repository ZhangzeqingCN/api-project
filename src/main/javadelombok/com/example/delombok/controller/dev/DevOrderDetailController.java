package com.example.delombok.controller.dev;


import com.example.delombok.access.Order;
import com.example.delombok.access.OrderDetail;
import com.example.delombok.domain.Result;
import com.example.delombok.repository.OrderDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/dev/orderDetail")
public class DevOrderDetailController {
    @Autowired
    private OrderDetailRepository orderDetailRepository;


    //查看某个订单的所有详细订单
    @GetMapping("/all")
    public Result findOrderDetailByOrder(@RequestBody Order order) {
        return Result.success(orderDetailRepository.findByOrder(order));
    }

    @PutMapping
    public Result updateOrderDetail(@RequestBody OrderDetail orderDetail){
        try {
            orderDetailRepository.save(orderDetail);
            return Result.success();
        } catch (Exception e) {
            return Result.error(e.getMessage()).addErrors(e);
        }
    }
    //删除订单详细
    @DeleteMapping
    public Result deleteOrderDetailById(@RequestParam Integer orderDetailId){
        try {
            orderDetailRepository.deleteById(orderDetailId);
            return Result.success();
        }catch (Exception e){
            return Result.error(e.getMessage()).addErrors(e);
        }
    }

    //增加订单详细信息
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
