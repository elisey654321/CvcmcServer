package ru.cvcmc.CvcmcServer.controller;

import com.fasterxml.jackson.databind.JsonMappingException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlingController {


    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<String> handleException(Exception e){

        //e.getBindingResult().getAllErrors()
        return null;
    }

    @ExceptionHandler(JsonMappingException.class)
    public
    ResponseEntity<String>handleJsonMappingException(JsonMappingException e){

        return null;

    }

}
