package com.example.spring_boot_quckly.domain;

import java.util.UUID;

public class Product {
    private String id;
    private String title;
    private float price;

    public Product() {
        this.id = UUID.randomUUID().toString();
    }

    public Product(String id, String title, float price) {
        this.id = id;
        this.title = title;
        this.price = price;
    }

    public Product(String title, float price) {
        this(UUID.randomUUID().toString(), title, price);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
