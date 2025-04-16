package com.mateusz113.git_hub_proj.git_hub_project.exception.repository;

import com.mateusz113.git_hub_proj.git_hub_project.exception.WebException;
import org.springframework.http.HttpStatus;

import java.time.OffsetDateTime;

public class RepositoryAlreadyExistsException extends WebException {
    public RepositoryAlreadyExistsException(String message, OffsetDateTime date) {
        super(message, HttpStatus.CONFLICT, date);
    }
}
