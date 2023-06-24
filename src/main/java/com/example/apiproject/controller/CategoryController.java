package com.example.apiproject.controller;


import com.example.apiproject.access.Category;
import com.example.apiproject.domain.Result;
import com.example.apiproject.repository.CategoryRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/category")
@Slf4j
@Tag(name = "CategoryController", description = "分类相关接口控制器")
public class CategoryController {

    private CategoryRepository categoryRepository;

    @Autowired
    public void setCategoryRepository(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    /**
     * 查询所有商品种类。
     *
     * @return 包含所有商品种类的结果对象。
     */
    @GetMapping("/all")
    @Operation(summary = "查询所有商品种类", description = "查询所有商品种类")
    public Result findAll() {
        return Result.success(categoryRepository.findAll());
    }

    /**
     * 更新商品种类信息。
     *
     * @param category 要更新的商品种类对象。
     * @return 更新结果的结果对象。
     */
    @PutMapping
    @Operation(summary = "更新商品种类信息", description = "更新商品种类信息")
    public Result updateCategory(@RequestBody Category category) {
        try {
            categoryRepository.save(category);
            return Result.success();
        } catch (Exception e) {
            return Result.error(e.getMessage()).addErrors(e);
        }
    }


    /**
     * 根据商品种类ID删除商品种类。
     * 如果该商品种类下存在商品，则无法删除。
     *
     * @param categoryId 要删除的商品种类ID。
     * @return 删除结果的结果对象。
     */
    @DeleteMapping
    @Operation(summary = "根据商品种类ID删除商品种类", description = "根据商品种类ID删除商品种类。")
    public Result deleteCategoryById(@RequestParam Integer categoryId) {
        try {
            categoryRepository.deleteById(categoryId);
            return Result.success();
        } catch (Exception e) {
            return Result.error(e.getMessage()).addErrors(e);
        }
    }

    /**
     * 添加商品种类信息。
     *
     * @param category 要添加的商品种类对象。
     * @return 添加结果的结果对象。
     */
    @PostMapping
    @Operation(summary = "添加商品种类信息", description = "添加商品种类信息")
    public Result addCategory(@RequestBody Category category) {
        try {
            categoryRepository.save(category);
            return Result.success();
        } catch (Exception e) {
            return Result.error(e.getMessage()).addErrors(e);
        }
    }

}
