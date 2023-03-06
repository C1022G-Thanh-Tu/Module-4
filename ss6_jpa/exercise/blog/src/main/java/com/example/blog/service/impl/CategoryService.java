package com.example.blog.service.impl;

import com.example.blog.Model.Category;
import com.example.blog.repository.ICategoryRepository;
import com.example.blog.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService implements ICategoryService {
    @Autowired
    private ICategoryRepository categoryRepository;

    @Override
    public List<Category> findAll(String name) {
        return categoryRepository.findAllByNameContaining(name);
    }

    @Override
    public void createCategory(Category category) {
        categoryRepository.save(category);
    }

}
