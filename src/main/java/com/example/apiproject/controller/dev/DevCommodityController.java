package com.example.apiproject.controller.dev;


import com.example.apiproject.access.Category;
import com.example.apiproject.access.Commodity;
import com.example.apiproject.domain.Result;
import com.example.apiproject.repository.CommodityRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/dev/commodity")
@Tag(name = "DevCommodityController", description = "DevCommodityController")
public class DevCommodityController {
    @Autowired
    private CommodityRepository commodityRepository;

    //查询所有商品
    @GetMapping("/all")
    @Operation(description = "查询所有商品", summary = "查询所有商品")
    public Result findAll() {
        return Result.success(commodityRepository.findAll());
    }


    //根据商品名称模糊查询
    @GetMapping("/{name}")
    @Operation(description = "根据商品名称模糊查询", summary = "根据商品名称模糊查询")
    public Result findCommodityByName(@PathVariable String name) {
        return Result.success(commodityRepository.findByCommodityNameLike(name));
    }

    //根据商品种类查询所有商品
    @GetMapping("/category")
    @Operation(description = "根据商品种类查询所有商品", summary = "根据商品种类查询所有商品")
    public Result findCommodityByCategory(@RequestBody Category category) {
        return Result.success(commodityRepository.findByCategory(category));
    }


    //添加商品
    @PostMapping
    @Operation(description = "添加商品", summary = "添加商品")
    public Result addCommodity(@RequestBody Commodity commodity) {
        try {
            commodityRepository.save(commodity);
            return Result.success();
        } catch (Exception e) {
            return Result.error(e.getMessage()).addErrors(e);
        }
    }

    //更新商品信息
    @PutMapping
    @Operation(description = "更新商品信息", summary = "更新商品信息")
    public Result updateCommodity(@RequestBody Commodity commodity) {
        try {
            commodityRepository.save(commodity);
            return Result.success();
        } catch (Exception e) {
            return Result.error(e.getMessage()).addErrors(e);
        }
    }

    //根据商品id删除商品
    @DeleteMapping
    @Operation(description = "根据商品id删除商品", summary = "根据商品id删除商品")
    public Result deleteCommodityById(@RequestParam Integer commodityId) {
        try {
            commodityRepository.deleteById(commodityId);
            return Result.success();
        } catch (Exception e) {
            return Result.error(e.getMessage()).addErrors(e);
        }
    }
}
