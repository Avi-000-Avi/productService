package com.example.demo.productservice.models;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product {
    private long id;
    private String title;
    private double price;
    private Category category;
    private String description;
}

