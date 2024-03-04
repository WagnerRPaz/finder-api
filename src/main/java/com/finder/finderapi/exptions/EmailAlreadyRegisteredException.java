package com.finder.finderapi.exptions;

public class EmailAlreadyRegisteredException extends RuntimeException{
    public EmailAlreadyRegisteredException(String msg) {
        super(msg);
    }
}
