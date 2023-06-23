package com.example.apiproject.controller;

import com.example.apiproject.access.ShoppingCart;
import com.example.apiproject.access.User;
import com.example.apiproject.domain.Result;
import com.example.apiproject.repository.ShoppingCartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/shoppingCart")
public class ShoppingCartController {
    @Autowired
    private ShoppingCartRepository shoppingCartRepository;

    /**
     * 查看所有购物车信息。
     *
     * @return 包含所有购物车信息的结果对象。
     */
    @GetMapping("/all")
    public Result findAll() {
        return Result.success(shoppingCartRepository.findAll());
    }

    /**
     * 根据用户查看他的购物车。
     *
     * @param user 用户对象。
     * @return 包含符合条件的购物车信息的结果对象。
     */
    @GetMapping("/user")
    public Result findAllByUser(@RequestBody User user) {
        return Result.success(shoppingCartRepository.findShoppingCartByUser(user));
    }

    /**
     * 更新购物车信息。
     *
     * @param shoppingCart 要更新的购物车对象。
     * @return 更新结果的结果对象。
     */
    @PutMapping
    public Result updateShoppingCart(@RequestBody ShoppingCart shoppingCart){
        try {
            shoppingCartRepository.save(shoppingCart);
            return Result.success();
        } catch (Exception e) {
            return Result.error(e.getMessage()).addErrors(e);
        }
    }

    /**
     * 根据购物车ID删除购物车信息。
     *
     * @param shoppingCartId 要删除的购物车ID。
     * @return 删除结果的结果对象。
     */
    @DeleteMapping
    public Result deleteShoppingCartById(@RequestParam Integer shoppingCartId){
        try {
            shoppingCartRepository.deleteById(shoppingCartId);
            return Result.success();
        }catch (Exception e){
            return Result.error(e.getMessage()).addErrors(e);
        }
    }

    /**
     * 增加购物车信息。
     *
     * @param shoppingCart 要添加的购物车对象。
     * @return 添加结果的结果对象。
     */
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
