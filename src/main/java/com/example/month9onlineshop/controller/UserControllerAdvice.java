package com.example.month9onlineshop.controller;

import org.apache.catalina.connector.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.validation.ConstraintViolationException;
import java.net.BindException;

@ControllerAdvice(assignableTypes = {UserController.class})
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class UserControllerAdvice {
    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<String> handleConstraintViolationException(ConstraintViolationException ex){
        return ResponseEntity.badRequest().body("not valid data");
    }
    @ExceptionHandler(BindException.class)
    public ResponseEntity<String> handleBindException(BindException ex) {
        return ResponseEntity.badRequest().body("not valid data");
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Response handleException(MethodArgumentNotValidException e) {
        return new Response(e.getErrorCount());
    }
}
