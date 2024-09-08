package com.emazon.stock.domain.exception;

public class SizeNotAllowedException extends RuntimeException{
    public SizeNotAllowedException(String message) {
        super(message);
    }
}
