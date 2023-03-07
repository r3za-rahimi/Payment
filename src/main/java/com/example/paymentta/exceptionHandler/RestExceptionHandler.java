package com.example.paymentta.exceptionHandler;


import com.example.paymentta.exceptions.ExceptionResponse;
import com.example.paymentta.exceptions.ServiceException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class RestExceptionHandler {


    @ExceptionHandler(ServiceException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ExceptionResponse> getException(ServiceException serviceException) {

        ExceptionResponse exceptionResponse = new ExceptionResponse();
        exceptionResponse.setError(true);
        exceptionResponse.setMessage(serviceException.getErrorCode());

        return ResponseEntity.badRequest().body(exceptionResponse);

    }

}
