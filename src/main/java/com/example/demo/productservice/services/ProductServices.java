package com.example.demo.productservice.services;

import com.example.demo.productservice.models.Product;

import java.util.List;

public interface ProductServices {
    Product getProductById(Long Id);

    List<Product> getAllProducts();

    Product createProduct(Product product);

    Product replaceProduct(Long Id, Product product);

    Product updateProduct(Long Id, Product product);

    void deleteProduct(Long Id);
}
