package com.app.rds.exceptions;

import com.app.rds.utility.CustomApiResponse;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(DataAccessException.class)
    public ResponseEntity<CustomApiResponse> handleDataAccessException(DataAccessException ex){
        String msg = "Error occured related to DB::"+ex.getMessage();
        return new ResponseEntity<>(new CustomApiResponse(msg), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
