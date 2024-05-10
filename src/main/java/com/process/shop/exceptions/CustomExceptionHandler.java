package com.process.shop.exceptions;


import com.process.shop.model.dto.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.lang.reflect.Field;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
@RestControllerAdvice
public class CustomExceptionHandler {
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<Response> notFoundExceptionHandler(NotFoundException notFoundException){
        return new ResponseEntity<>(
                Response.builder()
                        .date(LocalDate.now())
                        .message(List.of(notFoundException.getMessage()))
                        .statusCode(HttpStatus.NOT_FOUND.name())
                        .build(),
                HttpStatus.NOT_FOUND
        );
    }

    @ExceptionHandler(AlreadyExistsException.class)
    public ResponseEntity<Response> alreadyExistExceptionHandler(AlreadyExistsException alreadyExistsException){
        return new ResponseEntity<>(
                Response.builder()
                        .date(LocalDate.now())
                        .message(List.of(alreadyExistsException.getMessage()))
                        .statusCode(HttpStatus.CONFLICT.name())
                        .build(),
                HttpStatus.CONFLICT
        );
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public  ResponseEntity<Response> jakerthandler(MethodArgumentNotValidException ex){
        List<String> errores = new ArrayList<>();
        ex.getBindingResult().getAllErrors().forEach((error)->{
            errores.add(
                    ((FieldError)error).getField().concat(" - "+error.getDefaultMessage())
                );
            }
        );return new ResponseEntity<>(
                Response.builder()
                        .date(LocalDate.now())
                        .message(List.of(ex.getMessage()))
                        .statusCode(HttpStatus.NOT_FOUND.name())
                        .build(),
                HttpStatus.BAD_REQUEST
        );
    }

}