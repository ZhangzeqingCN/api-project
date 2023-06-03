package com.example.apiproject.controller.dev;

import com.example.apiproject.access.ShoppingCart;
import com.example.apiproject.domain.Result;
import com.example.apiproject.repository.ShoppingCartRepository;
import com.example.apiproject.repository.ShoppingCartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/dev/shoppingCart")
public class DevShoppingCartController {
    @Autowired
    private ShoppingCartRepository shoppingCartRepository;


    @GetMapping("/all")
    public Result all() {
        return Result.success(shoppingCartRepository.findAll());
    }

    @PutMapping
    public Result updateShoppingCart(@RequestBody ShoppingCart shoppingCart){
        try {
            shoppingCartRepository.save(shoppingCart);
            return Result.success();
        } catch (Exception e) {
            return Result.error(e.getMessage()).addErrors(e);
        }
    }

    @DeleteMapping
    public Result deleteShoppingCartById(@RequestParam Integer shoppingCartId){
        try {
            shoppingCartRepository.deleteById(shoppingCartId);
            return Result.success();
        }catch (Exception e){
            return Result.error(e.getMessage()).addErrors(e);
        }
    }


    @PostMapping
    public Result addShoppingCart(@RequestBody ShoppingCart shoppingCart){
        try {
            shoppingCartRepository.save(shoppingCart);
            return Result.success();
        } catch (Exception e) {
            return Result.error(e.getMessage()).addErrors(e);
        }
    }
}
