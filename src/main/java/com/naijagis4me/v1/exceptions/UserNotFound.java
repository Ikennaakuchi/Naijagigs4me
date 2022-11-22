package com.naijagis4me.v1.exceptions;

public class UserNotFound extends Exception {
    private String message;

    public UserNotFound(String message) {
        super(message);
    }
}
