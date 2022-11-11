package com.example.spring_boot_quckly.controller;

import com.example.spring_boot_quckly.domain.Product;
import com.example.spring_boot_quckly.repo.ProductRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@ResponseBody
@RequestMapping(value = "/products")
public class ProductControllerREST {
    private final ProductRepository productRepository;

    public ProductControllerREST(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @RequestMapping(method = RequestMethod.GET)
    public Iterable<Product> getProducts() {
        return productRepository.findAll();
    }

    @GetMapping("{id}")
    public Optional<Product> getProductById(@PathVariable String id) {
        return productRepository.getProductById(id);
    }

    @PostMapping
    public Product addProduct(@RequestBody Product product) {
        return productRepository.addProduct(product);
    }

    @PutMapping("{id}")
    public ResponseEntity<Optional<Product>> updateProduct(@PathVariable String id, @RequestBody Product product) {
        int index = productRepository.updateProduct(id, product);
        return index == -1
                ? new ResponseEntity<>(Optional.of(addProduct(product)), HttpStatus.CREATED)
                : new ResponseEntity<>(productRepository.getProductById(id), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public boolean deleteProductById(@PathVariable String id) {
        return productRepository.deleteProductById(id);
    }
}
