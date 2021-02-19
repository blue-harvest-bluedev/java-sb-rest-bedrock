package com.blueharvest.bluedev.bedrocksb.aop.exception;

import com.blueharvest.bluedev.bedrocksb.domain.exception.BadRequestException;
import com.blueharvest.bluedev.bedrocksb.domain.model.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

/**
 * Custom Exception Handler
 */
@ControllerAdvice
public class CustomExceptionHandler {

    /**
     * Handles the {@link BadRequestException} and returns the response.
     *
     * @param ex exception that was thrown
     * @return response to return
     */
    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ErrorResponse> badRequestExceptionHandler(BadRequestException ex) {
        ErrorResponse responseBody = ErrorResponse.builder()
                .timestamp(LocalDateTime.now())
                .httpResponse(HttpStatus.BAD_REQUEST.value())
                .message(ex.getMessage())
                .build();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseBody);
    }

    /**
     * Handles the {@link Exception} and returns the response
     *
     * @param ex exception that was thrown
     * @return response to return
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> defaultExceptionHandler(Exception ex) {
        ErrorResponse responseBody = ErrorResponse.builder()
                .timestamp(LocalDateTime.now())
                .httpResponse(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .message(ex.getMessage())
                .build();
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(responseBody);
    }
}