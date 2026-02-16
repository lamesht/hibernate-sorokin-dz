package sorokin_hibernate_dz.shared.exceptionHandler;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@ToString
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

}
