package com.example.apiproject.controller;

import com.example.delombok.access.Category;
import com.example.delombok.access.Commodity;
import com.example.delombok.domain.Result;
import com.example.delombok.repository.CommodityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/commodity")
public class CommodityController {

    @Autowired
    private CommodityRepository commodityRepository;

    /**
     * 查询所有商品。
     *
     * @return 包含所有商品的结果对象。
     */
    @GetMapping("/all")
    public Result findAll() {
        return Result.success(commodityRepository.findAll());
    }

    /**
     * 根据商品名称进行模糊查询。
     *
     * @param name 商品名称关键字。
     * @return 包含符合条件的商品的结果对象。
     */
    @GetMapping("/{name}")
    public Result findCommodityByName(@PathVariable String name) {
        return Result.success(commodityRepository.findByCommodityNameLike(name));
    }

    /**
     * 根据商品种类查询所有商品。
     *
     * @param category 商品种类对象。
     * @return 包含符合条件的商品的结果对象。
     */
    @GetMapping("/category")
    public Result findCommodityByCategory(@RequestBody Category category) {
        return Result.success(commodityRepository.findByCategory(category));
    }

    /**
     * 添加商品。
     *
     * @param commodity 要添加的商品对象。
     * @return 添加结果的结果对象。
     */
    @PostMapping
    public Result addCommodity(@RequestBody Commodity commodity){
        try {
            commodityRepository.save(commodity);
            return Result.success();
        } catch (Exception e) {
            return Result.error(e.getMessage()).addErrors(e);
        }
    }

    /**
     * 更新商品信息。
     *
     * @param commodity 要更新的商品对象。
     * @return 更新结果的结果对象。
     */
    @PutMapping
    public Result updateCommodity(@RequestBody Commodity commodity){
        try {
            commodityRepository.save(commodity);
            return Result.success();
        } catch (Exception e) {
            return Result.error(e.getMessage()).addErrors(e);
        }
    }

    /**
     * 根据商品ID删除商品。
     *
     * @param commodityId 要删除的商品ID。
     * @return 删除结果的结果对象。
     */
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
