package com.efundzz.verificationservice.ErrorHandling;

public class InvalidRequestException extends RuntimeException {
    public InvalidRequestException(String message) {
        super(message);
    }
}
