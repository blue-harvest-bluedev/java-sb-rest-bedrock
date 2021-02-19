package com.blueharvest.bluedev.bedrocksb.domain.model;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

/**
 * Class that represents the response of the unhappy flow
 */
@Getter
@Builder
public class ErrorResponse {
    private LocalDateTime timestamp;
    private int httpResponse;
    private String message;
}