package com.mateusz113.git_hub_proj.git_hub_project.handler;

import com.mateusz113.git_hub_proj.git_hub_project.exception.WebException;
import com.mateusz113.git_hub_proj.git_hub_project.model.ErrorMessage;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GitProjectExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(exception = WebException.class)
    public ResponseEntity<Object> handlerWebException(WebException exception, WebRequest request) {
        ErrorMessage body = ErrorMessage.getFromWebException(exception);
        return handleExceptionInternal(exception, body, new HttpHeaders(), exception.getStatusCode(), request);
    }
}
