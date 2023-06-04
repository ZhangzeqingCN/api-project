package com.example.apiproject.controller.dev;




import com.example.apiproject.access.Category;
import com.example.apiproject.domain.Result;
import com.example.apiproject.repository.CategoryRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/dev/category")
@Slf4j
public class CategoryController {
    
    @Autowired
    private CategoryRepository categoryRepository;
    //查询所有商品种类
    @GetMapping("/all")
    public Result findAll() {
        return Result.success(categoryRepository.findAll());
    }


    //更新种类信息
    @PutMapping
    public Result updateCategory(@RequestBody Category category){
        try {
            categoryRepository.save(category);
            return Result.success();
        } catch (Exception e) {
            return Result.error(e.getMessage()).addErrors(e);
        }
    }

    //如果该商品种类下的商品不为null，则无法删除
    @DeleteMapping
    public Result deleteCategoryById(@RequestParam Integer categoryId){
        try {
            categoryRepository.deleteById(categoryId);
            return Result.success();
        }catch (Exception e){
            return Result.error(e.getMessage()).addErrors(e);
        }
    }

    //增加商品品种类信息
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
