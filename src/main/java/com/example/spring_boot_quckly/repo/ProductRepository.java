package com.example.spring_boot_quckly.repo;

import com.example.spring_boot_quckly.domain.Product;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Repository
public class ProductRepository {
    private List<Product> productList = new ArrayList<>();

    public ProductRepository() {
        init();
    }

    public List<Product> findAll() {
        return productList;
    }

    public Product addProduct(Product product) {
        productList.add(product);
        return product;
    }

    public Product addProduct(String title, float price) {
        int count = productList.size();
        Product product = new Product(title, price);
        productList.add(product);
        return product;
    }

    public boolean deleteProductById(String id) {
        return productList.removeIf(p -> p.getId().equals(id));
    }

    public Optional<Product> getProductById(String id) {
        for (Product p : productList) {
            if (p.getId().equals(id)) {
                return Optional.of(p);
            }
        }
        return Optional.empty();
    }

    public int updateProduct(String id, Product product) {
        int index = -1;
        for (Product p : productList) {
            if (p.getId().equals(id)) {
                index = productList.indexOf(p);
                product.setId(p.getId());
                productList.set(index, product);
            }
        }
        return index;
    }

    public void init() {
        if (productList.size() < 1) {
            productList.addAll(List.of(
                    new Product("1", "Product0", 12.00f),
                    new Product("Product1", 12.00f),
                    new Product("Product2", 12.10f),
                    new Product("Product3", 122.00f),
                    new Product("Product4", 2.00f),
                    new Product("Product5", 312.00f),
                    new Product("Product6", 100f)
            ));
        }
    }
}
