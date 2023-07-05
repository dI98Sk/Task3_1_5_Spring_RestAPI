package com.skakundima.spring.boot.KataTask_3_1_5.exception_handling;

public class NoSuchUserException extends RuntimeException{
    public NoSuchUserException(String message) {
        super(message);
    }
}