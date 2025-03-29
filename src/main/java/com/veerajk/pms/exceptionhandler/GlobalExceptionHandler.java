package com.veerajk.pms.exceptionhandler;

import com.veerajk.pms.exceptionhandler.exceptions.ProblemNotFoundException;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ChangeSetPersister.NotFoundException.class)
    public ResponseEntity<CustomErrorResponse> notFound(ChangeSetPersister.NotFoundException notFoundException){
        CustomErrorResponse errorResponse = new CustomErrorResponse(HttpStatus.NOT_FOUND,notFoundException.getMessage(),new Date());
        return new ResponseEntity<>(errorResponse,HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(ProblemNotFoundException.class)
    public ResponseEntity<CustomErrorResponse> problemNotFound(ProblemNotFoundException problemNotFoundException){
        CustomErrorResponse errorResponse = new CustomErrorResponse(HttpStatus.NOT_FOUND,problemNotFoundException.getMessage(),new Date());
        return new ResponseEntity<>(errorResponse,HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity<CustomErrorResponse> otherExceptions(Exception exception){
        CustomErrorResponse errorResponse = new CustomErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR,exception.getMessage(),new Date());
        return new ResponseEntity<>(errorResponse,HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
