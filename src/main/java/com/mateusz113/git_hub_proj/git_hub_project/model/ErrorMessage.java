package com.mateusz113.git_hub_proj.git_hub_project.model;

import com.mateusz113.git_hub_proj.git_hub_project.exception.WebException;
import org.springframework.http.HttpStatus;

import java.time.OffsetDateTime;

public record ErrorMessage(
        String message,
        HttpStatus status,
        OffsetDateTime date
) {
    public static ErrorMessage getFromWebException(WebException webException) {
        return new ErrorMessage(webException.getMessage(), webException.getStatusCode(), webException.getDate());
    }
}
