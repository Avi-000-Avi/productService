package com.example.demo.productservice.controllers;

import com.example.demo.productservice.models.Product;
import com.example.demo.productservice.services.ProductServices;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController  {

    private  ProductServices productService;

    ProductController(ProductServices productService){
        this.productService = productService;
    }

    @GetMapping("/{id}")
    //Ideally should return a Product DTO
    public ResponseEntity<Product> getProductById(@PathVariable("id") Long id){
        return new ResponseEntity<>(productService.getProductById(id), HttpStatus.INTERNAL_SERVER_ERROR) ;
    }

    @GetMapping
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }


    @PostMapping
    public Product createProduct(@RequestBody Product product){
        return new Product();
    }

    @PutMapping("/{id}")
    public Product replaceProduct(@PathVariable("id") Long id,@RequestBody Product product){
        return new Product();
    }

    @PatchMapping("/{id}")
    public Product updateProduct(@PathVariable("id") Long id,@RequestBody Product product){
        return productService.updateProduct(id,product);
    }

    @DeleteMapping("/{id}")
    public Product deleteProductById(@PathVariable("id") Long id){
        return new Product();
    }
}
