package com.dogadjaji.dogadjaji_188.controllers;

import com.dogadjaji.dogadjaji_188.models.Category;
import com.dogadjaji.dogadjaji_188.requests.CategoryRequest;
import com.dogadjaji.dogadjaji_188.services.CategoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/categories")
@CrossOrigin(origins = "*", maxAge = 3600)
public class CategoryController {
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public List<Category> getCategories(){
        return categoryService.getCategories();
    }

    @GetMapping("/{id}")
    public Category getCategory(@PathVariable("id") Integer id){
        return categoryService.getCategory(id);
    }

    @PostMapping
    public String addCategory(@RequestBody CategoryRequest categoryRequest){
        categoryService.addCategory(categoryRequest);
        return "You added new category successfully!";
    }

    @PutMapping("/{id}")
    public String updateCategory(@PathVariable("id") Integer id, @RequestBody CategoryRequest categoryRequest){
        categoryService.updateCategory(id, categoryRequest);
        return "You update category successfully!";
    }
}
