package com.example.demo.productservice.advices;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class ExceptionHandler {
    @org.springframework.web.bind.annotation.ExceptionHandler({RuntimeException.class,NullPointerException.class})
    public ResponseEntity<String> handleException(){
        System.out.println("Something Went Wrong");
        return new ResponseEntity<>("Something Went Wrong", HttpStatus.NOT_FOUND);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(IndexOutOfBoundsException.class)
    public ResponseEntity<String> handleIndexException(){
        System.out.println("Something Went Wrong");
        return new ResponseEntity<>("Something Went Wrong",HttpStatus.NOT_FOUND);
    }
}
