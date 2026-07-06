package com.app.rds.exceptions;

import com.app.rds.utility.CustomApiResponse;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    private final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(DataAccessException.class)
    public ResponseEntity<CustomApiResponse> handleDataAccessException(DataAccessException ex, HttpServletRequest httpServletRequest){
        logger.error("DB related exception occurred:: URI={}, method={}, exception={}, message={}",
                httpServletRequest.getRequestURI(),
                httpServletRequest.getMethod(),
                ex.getClass().getSimpleName(),
                ex.getMessage(),
                ex);
        String msg = "Error occured related to DB::"+ex.getMessage();
        return new ResponseEntity<>(new CustomApiResponse(msg), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(PolicyNotFoundException.class)
    public ResponseEntity<CustomApiResponse> handlePolicyNotFoundException(PolicyNotFoundException ex, HttpServletRequest httpServletRequest){
        logger.error("Exception occurred::URI={}, method={}, exception={}, message={}",
                httpServletRequest.getRequestURI(),
                httpServletRequest.getMethod(),
                ex.getClass().getSimpleName(),
                ex.getMessage(),
                ex);
        return new ResponseEntity<>(new CustomApiResponse(ex.getMessage()),HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
