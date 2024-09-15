package com.example.demo.productservice.controllers;

import com.example.demo.productservice.exceptions.ProductLimitReachedException;
import com.example.demo.productservice.models.Product;
import com.example.demo.productservice.services.ProductServices;
import com.example.demo.productservice.services.TokenService;
import org.springframework.beans.factory.annotation.Qualifier;
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

    private TokenService tokenService;

    //@Qualifier("selfProductService")

    ProductController( ProductServices productService, TokenService tokenService){
        this.productService = productService;
        this.tokenService = tokenService;

    }

    @GetMapping("/{id}")
    //Ideally should return a Product DTO
    public ResponseEntity<Product> getProductbyId(@PathVariable("id") Long id){
//        if(!tokenService.validateToken(token)) {
//            return new ResponseEntity<>(null, HttpStatus.FORBIDDEN);
//        }
        return new ResponseEntity<>(productService.getProductById(id), HttpStatus.OK);
    }

    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        // You can create a package product validations and productValidations.validateProduct() use to validate
        return productService.createProduct(product);
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
//    @org.springframework.web.bind.annotation.ExceptionHandler({RuntimeException.class})
//    public ResponseEntity<String> handleException(){
//        System.out.println("Something Went Wrong");
//        return new ResponseEntity<>("Something Went Wrong", HttpStatus.INTERNAL_SERVER_ERROR);
//    }
}
