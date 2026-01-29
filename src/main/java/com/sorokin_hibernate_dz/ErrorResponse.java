package com.sorokin_hibernate_dz;

import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Getter
public class ErrorResponse{
    private final HttpStatus httpStatus;
    private final String message;
    private final LocalDateTime timeStamp;

    public ErrorResponse(HttpStatus httpStatus, String message) {
        this.httpStatus = httpStatus;
        this.message = message;
        this.timeStamp = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "ErrorResponse{" +
                "httpStatus=" + httpStatus +
                ", message='" + message + '\'' +
                ", timeStamp=" + timeStamp +
                '}';
    }
}
