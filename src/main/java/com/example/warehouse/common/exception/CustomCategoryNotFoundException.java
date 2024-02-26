package com.example.warehouse.common.exception;

public class CustomCategoryNotFoundException extends RuntimeException{

    public CustomCategoryNotFoundException(String message){
        super(message);
    }
}
