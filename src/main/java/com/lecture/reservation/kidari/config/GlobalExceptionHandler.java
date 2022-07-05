package com.lecture.reservation.kidari.config;

import com.lecture.reservation.kidari.exceptions.NotReserveException;
import com.lecture.reservation.kidari.model.error.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.NoSuchElementException;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NoSuchElementException.class)
    protected ResponseEntity<ErrorResponse> handlerNoSuchElementException(NoSuchElementException e){
        final ErrorResponse response = ErrorResponse.of(404, e.getMessage());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NotReserveException.class)
    protected ResponseEntity<ErrorResponse> handlerNotReserveException(NotReserveException e){
        final ErrorResponse response = ErrorResponse.of(404, e.getMessage());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}
