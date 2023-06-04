package com.example.apiproject.controller.dev;



import com.example.apiproject.access.Category;
import com.example.apiproject.access.Commodity;
import com.example.apiproject.domain.Result;
import com.example.apiproject.repository.CommodityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/dev/commodity")
public class CommodityController {

    @Autowired
    private CommodityRepository commodityRepository;

    //查询所有商品
    @GetMapping("/all")
    public Result findAll() {
        return Result.success(commodityRepository.findAll());
    }


    //根据商品名称模糊查询
    @GetMapping("/{name}")
    public Result findCommodityByName(@PathVariable String name) {
        return Result.success(commodityRepository.findByCommodityNameLike(name));
    }

    //根据商品种类查询所有商品
    @GetMapping("/category")
    public Result findCommodityByCategory(@RequestBody Category category) {
        return Result.success(commodityRepository.findByCategory(category));
    }


    //添加商品
    @PostMapping
    public Result addCommodity(@RequestBody Commodity commodity){
        try {
            commodityRepository.save(commodity);
            return Result.success();
        } catch (Exception e) {
            return Result.error(e.getMessage()).addErrors(e);
        }
    }

    //更新商品信息
    @PutMapping
    public Result updateCommodity(@RequestBody Commodity commodity){
        try {
            commodityRepository.save(commodity);
            return Result.success();
        } catch (Exception e) {
            return Result.error(e.getMessage()).addErrors(e);
        }
    }

    //根据商品id删除商品
    @DeleteMapping
    public Result deleteCommodityById(@RequestParam Integer commodityId){
        try {
            commodityRepository.deleteById(commodityId);
            return Result.success();
        }catch (Exception e){
            return Result.error(e.getMessage()).addErrors(e);
        }
    }
}
