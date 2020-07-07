package com.example.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

public class globalExceptionHandler extends ResponseEntityExceptionHandler {

@ExceptionHandler(value = NoBookingFoundException.class)
 public final ResponseEntity<Object> handleNoBookingFoundException(NoBookingFoundException ex, WebRequest request){

     ErrorDetails errorDetails = new ErrorDetails(new Date(),ex.getMessage(),request.getDescription(false));
//     errorDetails.setErrorDetails(request.getDescription(false));
//     errorDetails.setTimestamp(new Date());
//     errorDetails.setMessage(ex.getMessage());

     return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
 }

}
