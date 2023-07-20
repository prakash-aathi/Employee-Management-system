package com.assignment.employee.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.assignment.employee.dto.ErrorResponse;
import java.util.Date;

@ControllerAdvice
public class handleValidationExceptions  {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> customValidationErrorHandling(MethodArgumentNotValidException exception) {
        ErrorResponse error = new ErrorResponse(new Date(), "Validation Error",
                exception.getBindingResult().getFieldError().getDefaultMessage());
        return new ResponseEntity<>( error, HttpStatus.BAD_REQUEST );
    }


}
