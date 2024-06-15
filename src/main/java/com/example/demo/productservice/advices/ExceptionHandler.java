package com.example.demo.productservice.advices;

import com.example.demo.productservice.dtos.ExceptionDto;
import com.example.demo.productservice.exceptions.ProductLimitReachedException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class ExceptionHandler {
    @org.springframework.web.bind.annotation.ExceptionHandler({RuntimeException.class})
    public ResponseEntity<String> handleException(){
        System.out.println("Something Went horribly Wrong");
        return new ResponseEntity<>("Something Went  horribly Wrong", HttpStatus.NOT_FOUND);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(ProductLimitReachedException.class)
    public ResponseEntity<ExceptionDto> handleCustomException(ProductLimitReachedException e){
        System.out.println("Something Went Wrong");
        ExceptionDto exceptionDto = new ExceptionDto();
        exceptionDto.setErrorCode("PRODUCT_LIMIT_REACHED");
        exceptionDto.setMessage("Custom Exception Handler");
        return new ResponseEntity<>(exceptionDto,HttpStatus.NOT_FOUND);
    }
}
