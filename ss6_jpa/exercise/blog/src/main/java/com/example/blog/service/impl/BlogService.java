package com.example.blog.service.impl;

import com.example.blog.Model.Blog;
import com.example.blog.repository.IBlogRepository;
import com.example.blog.repository.ICategoryRepository;
import com.example.blog.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService implements IBlogService {
    @Autowired
    private IBlogRepository blogRepository;
    @Autowired
    private ICategoryRepository categoryRepository;
    @Override
    public List<Blog> findAll(String name) {
        return blogRepository.findByAuthorNameContaining(name);
    }

    @Override
    public void createBlog(Blog blog) {
        blogRepository.save(blog);
    }

    @Override
    public Blog findBlogById(int id) {
        return blogRepository.findById(id).get();
    }

    @Override
    public void deleteBlog(int id) {
        blogRepository.delete(findBlogById(id));
    }

    @Override
    public void updateBlog(Blog blog) {
        Blog b = findBlogById(blog.getId());
        b.setAuthorName(blog.getAuthorName());
        b.setTitle(blog.getTitle());
        b.setContent(blog.getContent());
        b.setCategory(blog.getCategory());
        blogRepository.save(b);
    }
}
