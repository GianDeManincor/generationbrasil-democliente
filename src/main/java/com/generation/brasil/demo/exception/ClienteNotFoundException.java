package com.generation.brasil.demo.exception;


public class ClienteNotFoundException extends Exception{

    private int statusCode;
    private String message;

    public ClienteNotFoundException(String message, int statusCode) {
        this.statusCode = statusCode;
        this.message = message;
    }

    public int getStatusCode() {
        return statusCode;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
