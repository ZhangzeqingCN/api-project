package com.example.apiproject.controller.dev;


import com.example.apiproject.access.Order;
import com.example.apiproject.access.OrderDetail;
import com.example.apiproject.domain.Result;
import com.example.apiproject.repository.OrderDetailRepository;
import com.example.apiproject.repository.OrderDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/dev/orderDetail")
public class DevOrderDetailController {
    @Autowired
    private OrderDetailRepository orderDetailRepository;


    @GetMapping("/all")
    public Result findOrderDetailById(@RequestParam Integer commodity) {
        return Result.success(orderDetailRepository.findAll());
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

    @DeleteMapping
    public Result deleteOrderDetailById(@RequestParam Integer orderId){
        try {
            orderDetailRepository.deleteById(orderId);
            return Result.success();
        }catch (Exception e){
            return Result.error(e.getMessage()).addErrors(e);
        }
    }


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
