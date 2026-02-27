package com.example.nursery_web.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.nursery_web.model.Category;
import com.example.nursery_web.repository.CategoryRepository;

@Service
public class CategoryService {
    
    private final CategoryRepository categoryRepo;

    public CategoryService(CategoryRepository categoryRepo)
    {
        this.categoryRepo = categoryRepo;
    }

    @Transactional(readOnly = true)
    public List<Category> getAllCategories()
    {
        return categoryRepo.findAll();
    }

    public Category addCategory(Category category)
    {   
        return categoryRepo.save(category);
    }

    @Transactional
    public Category updateCategory(Category category)
    {   
        Category exist = categoryRepo.findById(category.getCatId())
                         .orElseThrow(() -> new RuntimeException("Category not found"));
        exist.setCatImageUrl(category.getCatImageUrl());
        exist.setCatName(category.getCatName());
        return exist;
    }

    public void deleteCategory(Long catId)
    {
        categoryRepo.deleteById(catId);
    }
}
