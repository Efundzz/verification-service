package com.efundzz.verificationservice.ErrorHandling;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;



@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred: " + e.getMessage());
    }


    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<String> handleAccessDeniedException(AccessDeniedException e) {
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Access denied: " + e.getMessage());
    }
    @ExceptionHandler(AuthenticationException.class)
    public ResponseEntity<String> handleAuthenticationException(AuthenticationException e) {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Authentication failed: " + e.getMessage());
    }
    @ExceptionHandler(com.efundzz.verificationservice.ErrorHandling.InvalidRequestException.class)
    public ResponseEntity<String> handleInvalidRequestException(com.efundzz.verificationservice.ErrorHandling.InvalidRequestException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid request: " + e.getMessage());
    }

    @ExceptionHandler(com.efundzz.verificationservice.ErrorHandling.ResourceNotFoundException.class)
    public ResponseEntity<String> handleResourceNotFoundException(com.efundzz.verificationservice.ErrorHandling.ResourceNotFoundException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Resource not found: " + e.getMessage());
    }

//    @ExceptionHandler(ValidationException.class)
//    public ResponseEntity<Map<String, String>> handleValidationException(ValidationException e) {
//        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body((Map<String, String>) e.getFieldErrors());
//    }

}
