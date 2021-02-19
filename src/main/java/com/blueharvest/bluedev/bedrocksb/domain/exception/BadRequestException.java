package com.blueharvest.bluedev.bedrocksb.domain.exception;

import lombok.Getter;

/**
 * Custom exception that represents a BadRequest
 */
public class BadRequestException extends RuntimeException {
    @Getter
    private final String message;

    public BadRequestException(String message) {
        this.message = message;
    }
}