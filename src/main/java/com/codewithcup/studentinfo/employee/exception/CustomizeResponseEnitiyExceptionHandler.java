package com.codewithcup.studentinfo.employee.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@ControllerAdvice
@RestController
public class CustomizeResponseEnitiyExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<Object> handleAllException(Exception ex, WebRequest request) {
        GlobalExceptionResponse globalExceptionResponse = new GlobalExceptionResponse(new Date(), ex.getMessage(), request.getDescription(false));
        return new ResponseEntity(globalExceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(UserNotFoundException.class)
    public final ResponseEntity<Object> handleUserNotFoundException(UserNotFoundException ex, WebRequest request) {
        GlobalExceptionResponse globalExceptionResponse = new GlobalExceptionResponse(new Date(), ex.getMessage(), request.getDescription(false));
        return new ResponseEntity(globalExceptionResponse, HttpStatus.NOT_FOUND);
    }
}
