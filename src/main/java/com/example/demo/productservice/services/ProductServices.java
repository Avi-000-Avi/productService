package com.example.demo.productservice.services;

import com.example.demo.productservice.models.Product;
import java.util.List;

public interface ProductServices {
    Product getProductById(Long Id);

    List<Product> getAllProducts();

    Product createProduct(Product product);

    Product replaceProduct(Product product);

    Product updateProduct(Long id,Product product);

    void deleteProduct(Long Id);
}


