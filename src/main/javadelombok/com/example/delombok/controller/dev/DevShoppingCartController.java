package com.example.delombok.controller.dev;



import com.example.delombok.access.ShoppingCart;
import com.example.delombok.access.User;
import com.example.delombok.domain.Result;
import com.example.delombok.repository.ShoppingCartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/dev/shoppingCart")
public class DevShoppingCartController {
    @Autowired
    private ShoppingCartRepository shoppingCartRepository;

    //查看所有购物车信息
    @GetMapping("/all")
    public Result findAll() {
        return Result.success(shoppingCartRepository.findAll());
    }
    //根据用户查看他的购物车
    @GetMapping("/user")
    public Result findAllByUser(@RequestBody User user) {
        return Result.success(shoppingCartRepository.findShoppingCartByUser(user));
    }

    //更新商品信息
    @PutMapping
    public Result updateShoppingCart(@RequestBody ShoppingCart shoppingCart){
        try {
            shoppingCartRepository.save(shoppingCart);
            return Result.success();
        } catch (Exception e) {
            return Result.error(e.getMessage()).addErrors(e);
        }
    }

    //根据id删除商品信息
    @DeleteMapping
    public Result deleteShoppingCartById(@RequestParam Integer shoppingCartId){
        try {
            shoppingCartRepository.deleteById(shoppingCartId);
            return Result.success();
        }catch (Exception e){
            return Result.error(e.getMessage()).addErrors(e);
        }
    }


    //增加购物车信息
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
