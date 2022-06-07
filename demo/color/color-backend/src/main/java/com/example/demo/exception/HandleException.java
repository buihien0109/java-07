package com.example.demo.exception;

import com.example.demo.model.response.ResponseObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class HandleException {
    @ExceptionHandler(BadRequestException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ResponseObject> handlerBadRequestException(BadRequestException ex, WebRequest req) {
        return new ResponseEntity<>(
                new ResponseObject("false", ex.getMessage(), ""), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<ResponseObject> handlerNotFoundException(NotFoundException ex, WebRequest req) {
        return new ResponseEntity<>(
                new ResponseObject("false", ex.getMessage(), ""), HttpStatus.NOT_FOUND);
    }

    // Xử lý tất cả các exception chưa được khai báo
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<ResponseObject> handlerException(Exception ex, WebRequest req) {
        return new ResponseEntity<>(
                new ResponseObject("false", ex.getMessage(), ""), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
