package com.example.demo.controller;

import com.example.demo.entity.Category;
import com.example.demo.payload.CategoryDto;
import com.example.demo.payload.Result;
import com.example.demo.servise.CategoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {
    final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }


    @PostMapping
    public Result addCategory(@RequestBody CategoryDto categoryDto){
return categoryService.addCategory(categoryDto);
    }
    @GetMapping(value = "/get")
    public List<Category> getCategories(){
        List<Category> categoryList = categoryService.getCategories();
        return categoryList;
    }

    @GetMapping(value = "/subCategory/{parentCategoryId}")
    public Result getSubCategory(@PathVariable Integer parentCategoryId){

        Result subCategory = categoryService.getSubCategory(parentCategoryId);
        return subCategory;
    }

    @PutMapping(value = "/{categoryID}")
    public Result editCategory(@PathVariable Integer categoryID, @RequestBody CategoryDto categoryDTO){

        Result result = categoryService.editCategory(categoryID, categoryDTO);
        return result;
    }

    @DeleteMapping(value = "/{categoryID}")
    public Result deleteCategory(@PathVariable Integer categoryID){

        Result result = categoryService.deleteCategory(categoryID);
        return result;
    }
}
