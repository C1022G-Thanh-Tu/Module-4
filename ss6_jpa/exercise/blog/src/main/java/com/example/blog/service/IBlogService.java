package com.example.blog.service;

import com.example.blog.Model.Blog;
import com.example.blog.Model.Category;

import java.util.List;

public interface IBlogService {
    List<Blog> findAll (String name);
    void createBlog (Blog blog);
    Blog findBlogById(int id);
    void deleteBlog (int id);
    void updateBlog (Blog blog);
}
