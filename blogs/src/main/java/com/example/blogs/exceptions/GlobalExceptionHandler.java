package com.example.blogs.exceptions;

import com.example.blogs.dtos.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponse> resourceNotFoundException(ResourceNotFoundException exception)
    {
        String message = exception.getMessage();
        ApiResponse apiResponse = new ApiResponse(message,false);
        return ResponseEntity.ok(apiResponse);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String,String> methodNotValidException(MethodArgumentNotValidException exception)
    {
        Map<String,String> errors = new HashMap<>();
        exception.getBindingResult().getFieldErrors().forEach((error)->errors.put(error.getField(),error.getDefaultMessage()));
        return errors;
    }
}
