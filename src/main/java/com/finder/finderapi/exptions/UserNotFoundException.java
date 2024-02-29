package com.finder.finderapi.exptions;

public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException(String msg, Long user_id) {
        super(msg + user_id);
    }
}