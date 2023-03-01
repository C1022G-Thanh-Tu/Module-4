package com.example.controller;

import com.example.model.Product;
import com.example.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    IProductService productService;
    @GetMapping("")
    public String showProductList (@RequestParam(required = false) String name, Model model) {
        model.addAttribute("productList", productService.listProductByName(name));
        return "list";
    }

    @GetMapping("/create")
    public String showCreationForm (Model model) {
        model.addAttribute("product", new Product());
        return "create";
    }

    @PostMapping("/create")
    public String performCreate (@ModelAttribute Product product) {
        productService.createProduct(product);
        return "redirect:/product";
    }

    @GetMapping("/detail")
    public String showProductDetail (@RequestParam int id, Model model) {
        model.addAttribute("product", productService.findById(id));
        return "detail";
    }

    @GetMapping("/edit")
    public String showUpdateForm (@RequestParam int id, Model model) {
        model.addAttribute("product", productService.findById(id));
        return "edit";
    }

    @PostMapping("/edit")
    public String performUpdate (@ModelAttribute Product product, Model model) {
        productService.updateProduct(product);
        model.addAttribute("product", product);
        return "redirect:/product";
    }

    @GetMapping("/delete")
    public String performDelete (@RequestParam int deleteId) {
        productService.deleteProduct(deleteId);
        return "redirect:/product";
    }
}
