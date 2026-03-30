package com.ecomerce.mock.ecommerce_api.handler;

import com.ecomerce.mock.ecommerce_api.exception.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import com.ecomerce.mock.ecommerce_api.dto.ErrorResponse;

@ControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(ResourceNotFoundException .class)
    public ResponseEntity<ErrorResponse>    handleResourceNotFound(ResourceNotFoundException e) {
        ErrorResponse error = new ErrorResponse(e.getMessage());
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(error);
    }

}
