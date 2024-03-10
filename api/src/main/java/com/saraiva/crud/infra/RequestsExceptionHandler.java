package com.saraiva.crud.infra;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice // calls this class whenever an exception is thrown
public class RequestsExceptionHandler {
    @ExceptionHandler(EntityNotFoundException.class) //whenever an entity is not found
    public ResponseEntity threat404(){
        ExceptionResponseDTO response = new ExceptionResponseDTO("Não encontrado!");
        return ResponseEntity.badRequest().body(response.getResponse());
    }
}
