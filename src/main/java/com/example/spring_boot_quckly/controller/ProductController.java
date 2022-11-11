package com.example.spring_boot_quckly.controller;

import com.example.spring_boot_quckly.domain.Product;
import com.example.spring_boot_quckly.repo.ProductRepository;
import com.example.spring_boot_quckly.service.UserManagerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ProductController {
    private final ProductRepository productRepository;
    private final UserManagerService userManagerService;

    public ProductController(ProductRepository productRepository, UserManagerService userManagerService) {
        this.productRepository = productRepository;
        this.userManagerService = userManagerService;
    }

    @PostMapping("/product")
    public String addProduct(String title, String price, Model model) {
        if (!StringUtils.hasLength(title) && !StringUtils.hasLength(price)) {
            return "redirect:/product";
        } else if (userManagerService.getUserName() == null) {
            return "redirect:/login";
        }
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
