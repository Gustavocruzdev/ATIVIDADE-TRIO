package com.example.leaibackend.exception;


public class BusinessException extends RuntimeException{
    public BusinessException(String message){
        super(message);
    }
}
