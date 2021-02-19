package com.blueharvest.bluedev.bedrocksb.aop.exception;

import com.blueharvest.bluedev.bedrocksb.domain.exception.BadRequestException;
import com.blueharvest.bluedev.bedrocksb.domain.model.ErrorResponse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class CustomExceptionHandlerTest {

    @InjectMocks
    private CustomExceptionHandler underTest;

    @Test
    @DisplayName("SHOULD return an ErrorResponse with BAD REQUEST response WHEN an BadRequestException is thrown")
    void badRequestExceptionHandlerTest() {
        // given
        String exceptionMessage = "this-is-the-response-message";
        BadRequestException ex = new BadRequestException(exceptionMessage);
        // when
        ResponseEntity<ErrorResponse> actual = underTest.badRequestExceptionHandler(ex);
        // then
        assertNotNull(actual);
        assertEquals(HttpStatus.BAD_REQUEST, actual.getStatusCode());
        assertNotNull(actual.getBody());
        ErrorResponse actualBody = actual.getBody();
        assertEquals(HttpStatus.BAD_REQUEST.value(), actualBody.getHttpResponse());
        assertEquals(exceptionMessage, actualBody.getMessage());
        assertNotNull(actualBody.getTimestamp());
    }

    @Test
    @DisplayName("SHOULD return an ErrorResponse with INTERNAL SERVER response WHEN an RuntimeException is thrown")
    void defaultExceptionHandlerTest() {
        // given
        String exceptionMessage = "this-is-the-response-message";
        Exception ex = new RuntimeException(exceptionMessage);
        // when
        ResponseEntity<ErrorResponse> actual = underTest.defaultExceptionHandler(ex);
        // then
        assertNotNull(actual);
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, actual.getStatusCode());
        assertNotNull(actual.getBody());
        ErrorResponse actualBody = actual.getBody();
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR.value(), actualBody.getHttpResponse());
        assertEquals(exceptionMessage, actualBody.getMessage());
        assertNotNull(actualBody.getTimestamp());
    }
}
