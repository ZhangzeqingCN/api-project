package com.example.apiproject.controller.dev;


import com.example.apiproject.access.Category;
import com.example.apiproject.domain.Result;
import com.example.apiproject.repository.CategoryRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/dev/category")
@Slf4j
@Tag(name = "DevCategoryController", description = "DevCategoryController")
public class DevCategoryController {

    @Autowired
    private CategoryRepository categoryRepository;

    //查询所有商品种类
    @GetMapping("/all")
    @Operation(description = "查询所有商品种类")
    public Result findAll() {
        return Result.success(categoryRepository.findAll());
    }


    //更新种类信息
    @PutMapping
    @Operation(description = "更新种类信息")
    public Result updateCategory(@RequestBody Category category) {
        try {
            categoryRepository.save(category);
            return Result.success();
        } catch (Exception e) {
            return Result.error(e.getMessage()).addErrors(e);
        }
    }

    //如果该商品种类下的商品不为null，则无法删除
    @DeleteMapping
    @Operation(description = "删除商品种类")
    public Result deleteCategoryById(@RequestParam Integer categoryId) {
        try {
            categoryRepository.deleteById(categoryId);
            return Result.success();
        } catch (Exception e) {
            return Result.error(e.getMessage()).addErrors(e);
        }
    }

    //增加商品品种类信息
    @PostMapping
    @Operation(description = "增加商品品种类信息")
    public Result addCategory(@RequestBody Category category) {
        try {
            categoryRepository.save(category);
            return Result.success();
        } catch (Exception e) {
            return Result.error(e.getMessage()).addErrors(e);
        }
    }
}
