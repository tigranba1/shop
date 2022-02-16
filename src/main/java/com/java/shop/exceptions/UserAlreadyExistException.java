package com.java.shop.exceptions;

public class UserAlreadyExistException extends Exception {

    public UserAlreadyExistException(String message) {
        super("User already exist");
    }

}
