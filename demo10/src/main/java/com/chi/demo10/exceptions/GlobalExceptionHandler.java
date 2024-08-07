package com.chi.demo10.exceptions;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.chi.demo10.accounts.dto.ErrorResponseDto;

public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    // protected ResponseEntity<Object> handleMethodArgumentNotValid() {

    // }

    public ResponseEntity<ErrorResponseDto> handleResourceNotFoundException(CustomerAlreadyExistException exception,
                                                                        WebRequest webRequest) {
        ErrorResponseDto errorResponseDto = new ErrorResponseDto(
            webRequest.getDescription(false), 
            HttpStatus.NOT_FOUND,
            exception.getMessage(), 
            LocalDateTime.now());
        return new ResponseEntity<>(errorResponseDto, HttpStatus.NOT_FOUND);
    }
}
