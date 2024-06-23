package com.example.demo.productservice.exceptions;

public class ProductLimitReachedException extends Exception {
    public ProductLimitReachedException(String s) {
        super(s);
    }
}
