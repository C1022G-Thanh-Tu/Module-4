package com.example.blog.service;

import com.example.blog.Model.Category;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ICategoryService {
    List<Category> findAll();
}
