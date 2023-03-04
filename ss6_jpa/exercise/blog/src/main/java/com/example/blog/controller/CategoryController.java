package com.example.blog.controller;

import com.example.blog.Model.Category;
import com.example.blog.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private ICategoryService categoryService;
    @GetMapping("")
    public String showCategoryList (Model model) {
        model.addAttribute("categoryList", categoryService.findAll());
        return "category-list";
    }

    @GetMapping("/create")
    public String showCreateForm (Model model) {
        model.addAttribute("category", new Category());
        return "/category-creation";
    }

    @PostMapping("/create")
    public String performCreate (@ModelAttribute Category category) {
        categoryService.createCategory(category);
        return "redirect:/blog";
    }
}
