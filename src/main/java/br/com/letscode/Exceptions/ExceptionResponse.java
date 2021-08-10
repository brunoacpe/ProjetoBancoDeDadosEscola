package br.com.letscode.Exceptions;
import java.time.LocalDateTime;
public class ExceptionResponse {

    private final LocalDateTime timeOccurrence = LocalDateTime.now();
    private String exceptionMessage;
    private String details;

    public ExceptionResponse(String exceptionMessage, String details) {
        this.exceptionMessage = exceptionMessage;
        this.details = details;
    }

    public LocalDateTime getTimeOccurrence() {
        return timeOccurrence;
    }

    public String getExceptionMessage() {
        return exceptionMessage;
    }

    public String getDetails() {
        return details;
    }
}
