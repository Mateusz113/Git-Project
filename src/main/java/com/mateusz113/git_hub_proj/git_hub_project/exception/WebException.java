package com.mateusz113.git_hub_proj.git_hub_project.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.time.OffsetDateTime;

@Getter
public abstract class WebException extends RuntimeException {
    private final HttpStatus statusCode;
    private final OffsetDateTime date;

    public WebException(String message, HttpStatus statusCode, OffsetDateTime date) {
        super(message);
        this.statusCode = statusCode;
        this.date = date;
    }
}
