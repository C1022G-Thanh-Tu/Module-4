package com.example.blog.controller;

import com.example.blog.dto.BlogDTO;
import com.example.blog.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/blog")
@CrossOrigin("*")
public class BlogController {
    @Autowired
    private IBlogService blogService;
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("")
    public Page<BlogDTO> getBlogs(@PageableDefault(size = 5) Pageable pageable,
                                  @RequestParam(required = false, defaultValue = "") String title) {

        return blogService.findAll(pageable, title);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/detail/{id}")
    public BlogDTO getBlogDetail(@PathVariable int id) {
        return blogService.findById(id);
    }
}
