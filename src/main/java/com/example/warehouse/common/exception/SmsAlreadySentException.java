package com.example.warehouse.common.exception;

public class SmsAlreadySentException extends RuntimeException{
    public SmsAlreadySentException(String message) {
        super(message);
    }
}
