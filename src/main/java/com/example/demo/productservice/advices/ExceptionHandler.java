package com.example.demo.productservice.advices;

import com.example.demo.productservice.dtos.ExceptionDto;
import com.example.demo.productservice.exceptions.ProductLimitReachedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class ExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(ExceptionHandler.class);

    @org.springframework.web.bind.annotation.ExceptionHandler({RuntimeException.class})
    public ResponseEntity<String> handleException(RuntimeException ex) {
        logger.error("Something Went horribly Wrong", ex);  // Log the exception with details
        return new ResponseEntity<>("Something Went horribly Wrong", HttpStatus.NOT_FOUND);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(ProductLimitReachedException.class)
    public ResponseEntity<ExceptionDto> handleCustomException(ProductLimitReachedException e){
        logger.error("Something Went Wrong");
        ExceptionDto exceptionDto = new ExceptionDto();
        exceptionDto.setErrorCode("PRODUCT_LIMIT_REACHED");
        exceptionDto.setMessage("Custom Exception Handler");
        return new ResponseEntity<>(exceptionDto, HttpStatus.NOT_FOUND);
    }
}
