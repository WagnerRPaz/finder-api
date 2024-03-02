package com.finder.finderapi.exptions;

public class ReviewAlreadyExistsException extends RuntimeException{
    public ReviewAlreadyExistsException(String msg) {
        super(msg);
    }
}
