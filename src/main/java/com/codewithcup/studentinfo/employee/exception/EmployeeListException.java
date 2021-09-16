package com.codewithcup.studentinfo.employee.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class EmployeeListException extends RuntimeException{

    public EmployeeListException(String message) {
        super(message);
    }
}
