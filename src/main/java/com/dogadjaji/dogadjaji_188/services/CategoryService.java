package com.dogadjaji.dogadjaji_188.services;

import com.dogadjaji.dogadjaji_188.models.Category;
import com.dogadjaji.dogadjaji_188.repositories.CategoryRepository;
import com.dogadjaji.dogadjaji_188.requests.CategoryRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> getCategories(){
        return categoryRepository.findAll();
    }

    public Category getCategory(int id){
        return categoryRepository.findById(id).orElseThrow();
    }

    public void addCategory(CategoryRequest categoryRequest){
        Category category = new Category();

        category.setName(categoryRequest.getName());
        category.setIcon(categoryRequest.getIcon());

        categoryRepository.save(category);
    }

    public void updateCategory(int id, CategoryRequest categoryRequest){
        Category category = getCategory(id);

        category.setName(categoryRequest.getName());
        category.setIcon(categoryRequest.getIcon());

        categoryRepository.save(category);
    }
}
