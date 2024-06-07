package com.process.shop.exceptions;

public class AuthenticationFailedException extends Throwable {
    public AuthenticationFailedException(String message) {
        super(message);
    }
}
