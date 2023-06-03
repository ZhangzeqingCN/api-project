package com.example.apiproject.controller.dev;


import com.example.apiproject.access.Category;
import com.example.apiproject.access.Category;
import com.example.apiproject.domain.Result;
import com.example.apiproject.repository.CategoryRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/dev/category")
@Slf4j
public class DevCategoryController {
    
    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping("/all")
    public Result all() {
        return Result.success(categoryRepository.findAll());
    }

    @PutMapping
    public Result updateCategory(@RequestBody Category category){
        try {
            categoryRepository.save(category);
            return Result.success();
        } catch (Exception e) {
            return Result.error(e.getMessage()).addErrors(e);
        }
    }

    @DeleteMapping
    public Result deleteCategoryById(@RequestParam Integer categoryId){
        try {
            categoryRepository.deleteById(categoryId);
            return Result.success();
        }catch (Exception e){
            return Result.error(e.getMessage()).addErrors(e);
        }
    }


    @PostMapping
    public Result addCategory(@RequestBody Category category){
        try {
            categoryRepository.save(category);
            return Result.success();
        } catch (Exception e) {
            return Result.error(e.getMessage()).addErrors(e);
        }
    }
}
