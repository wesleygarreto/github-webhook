package com.garreto.githubwebhook.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.concurrent.RejectedExecutionException;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RejectedExecutionException.class)
    public ResponseEntity<String> handleRejectedExecutionException(final RejectedExecutionException ex) {
        return ResponseEntity
                .status(HttpStatus.SERVICE_UNAVAILABLE)
                .body("The server is currently unable to handle the request due to overload. Please try again later.");
    }
}