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
//        try {
            return new ResponseEntity<>(productService.getProductById(id), HttpStatus.INTERNAL_SERVER_ERROR);
//        } catch (Exception e) {
//            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
//        }
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

//    @ExceptionHandler({RuntimeException.class,NullPointerException.class})
//    public ResponseEntity<String> handleException(){
//        System.out.println("Something Went Wrong");
//        return new ResponseEntity<>("Something Went Wrong",HttpStatus.NOT_FOUND);
//    }
//
//    @ExceptionHandler(IndexOutOfBoundsException.class)
//    public ResponseEntity<String> handleIndexException(){
//        System.out.println("Something Went Wrong");
//        return new ResponseEntity<>("Something Went Wrong",HttpStatus.NOT_FOUND);
//    }
}
