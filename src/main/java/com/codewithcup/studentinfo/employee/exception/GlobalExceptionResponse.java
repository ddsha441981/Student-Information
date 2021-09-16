package com.codewithcup.studentinfo.employee.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@NoArgsConstructor
@Getter
@Setter

public class GlobalExceptionResponse {
    private Date timestamp;
    private String message;
    private String detail;

    public GlobalExceptionResponse(Date timestamp, String message, String detail) {
        this.timestamp = timestamp;
        this.message = message;
        this.detail = detail;
    }


}
