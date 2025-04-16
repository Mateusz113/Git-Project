package com.mateusz113.git_hub_proj.git_hub_project.exception.repository;

import com.mateusz113.git_hub_proj.git_hub_project.exception.WebException;
import org.springframework.http.HttpStatus;

import java.time.OffsetDateTime;

public class RepositoryNotFoundException extends WebException {
    public RepositoryNotFoundException(String message, OffsetDateTime date) {
        super(message, HttpStatus.NOT_FOUND, date);
    }
}
