package com.example.blog.controller;

import com.example.blog.Model.Blog;
import com.example.blog.Model.Category;
import com.example.blog.service.IBlogService;
import com.example.blog.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    private IBlogService blogService;
    @Autowired
    private ICategoryService categoryService;
    @GetMapping("")
    public String showBlogList (@RequestParam(required = false, defaultValue = "") String name, Model model) {
        if (name == null) {
            name = "";
        }

        model.addAttribute("blogList", blogService.findAll(name));
        return "/list";
    }

    @GetMapping("/create")
    public String showCreateForm (Model model) {
        model.addAttribute("categoryList", categoryService.findAll());
        model.addAttribute("blog", new Blog());
        return "/create";
    }

    @PostMapping("/create")
    public String performCreate (@ModelAttribute Blog blog) {
        blogService.createBlog(blog);
        return "redirect:/blog";
    }

    @GetMapping("/detail")
    public String showBlogDetail (@RequestParam Integer id, Model model) {
        model.addAttribute("blog", blogService.findBlogById(id));
        return "/detail";
    }

    @GetMapping("/delete")
    public String performDelete (@RequestParam Integer deleteId) {
        blogService.deleteBlog(deleteId);
        return "redirect:/blog";
    }

    @GetMapping("/edit")
    public String showUpdateForm (@RequestParam Integer id, Model model) {
        model.addAttribute("categoryList", categoryService.findAll());
        model.addAttribute("blog", blogService.findBlogById(id));
        return "/edit";
    }

    @PostMapping("/edit")
    public String performUpdate (@ModelAttribute Blog blog) {
        blogService.updateBlog(blog);
        return "redirect:/blog";
    }
}
