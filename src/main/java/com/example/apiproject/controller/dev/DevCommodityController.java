package com.example.apiproject.controller.dev;

import com.example.apiproject.access.Commodity;
import com.example.apiproject.domain.Result;
import com.example.apiproject.repository.CommodityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/dev/commodity")
public class DevCommodityController {

    @Autowired
    private CommodityRepository commodityRepository;


    @GetMapping("/all")
    public Result all() {
        return Result.success(commodityRepository.findAll());
    }

    @GetMapping("/{name}")
    public Result one(@PathVariable String name) {
        return Result.success(commodityRepository.findByCommodityName(name));
    }



    @PostMapping
    public Result addCommodity(@RequestBody Commodity commodity){
        try {
            commodityRepository.save(commodity);
            return Result.success();
        } catch (Exception e) {
            return Result.error(e.getMessage()).addErrors(e);
        }
    }

    @PutMapping
    public Result updateCommodity(@RequestBody Commodity commodity){
        try {
            commodityRepository.save(commodity);
            return Result.success();
        } catch (Exception e) {
            return Result.error(e.getMessage()).addErrors(e);
        }
    }

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
