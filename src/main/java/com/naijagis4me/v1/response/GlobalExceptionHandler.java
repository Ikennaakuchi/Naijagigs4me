package com.naijagis4me.v1.response;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.sql.Timestamp;

@ControllerAdvice
public class GlobalExceptionHandler {

//    @ExceptionHandler(value = CustomerNotFoundException.class)
//    @ResponseStatus(HttpStatus.NOT_FOUND)
//    public @ResponseBody ErrorResponse handleException(CustomerNotFoundException ex) {
//        return ErrorResponse.builder()
//                .timestamp(new Timestamp(System.currentTimeMillis()))
//                .statusCode(HttpStatus.NOT_FOUND.value())
//                .errorMessage(ex.getMessage()).build();
//    }
//
//    @ExceptionHandler(value = SessionIdNotFoundException.class)
//    @ResponseStatus(HttpStatus.NOT_FOUND)
//    public @ResponseBody ErrorResponse handleException(SessionIdNotFoundException ex) {
//        return ErrorResponse.builder()
//                .timestamp(new Timestamp(System.currentTimeMillis()))
//                .statusCode(HttpStatus.NOT_FOUND.value())
//                .errorMessage(ex.getMessage()).build();
//    }

}
