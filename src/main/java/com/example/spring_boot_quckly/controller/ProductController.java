package com.example.spring_boot_quckly.controller;

import com.example.spring_boot_quckly.domain.Product;
import com.example.spring_boot_quckly.repo.ProductRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ProductController {
    private final ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @PostMapping("/product")
    public String addProduct(String title, String price, Model model) {
        productRepository.addProduct(title, Float.parseFloat(price));
        return "redirect:/product";
    }

    @GetMapping("/product")
    public String getProducts(Model model) {
        List<Product> productList = productRepository.findAll();
        model.addAttribute("products", productList);
        return "product";
    }
}
