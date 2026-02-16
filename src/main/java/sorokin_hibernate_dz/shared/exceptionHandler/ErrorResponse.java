package sorokin_hibernate_dz.shared.exceptionHandler;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;


public class ErrorResponse{
    @NotNull
    private final String code;
    @NotNull
    private final String message;
    @NotNull
    private final LocalDateTime timeStamp;

    public ErrorResponse(String code, String message) {
        this.code = code;
        this.message = message;
        this.timeStamp = LocalDateTime.now();
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }

    @Override
    public String toString() {
        return "ErrorResponse{" +
                "code='" + code + '\'' +
                ", message='" + message + '\'' +
                ", timeStamp=" + timeStamp +
                '}';
    }
}
