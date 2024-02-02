package com.ejercicio.tecnico.com.ejercicio.tecnico.aplicacion.ErrorHandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CorreoRegistradoException.class)
    public ResponseEntity<ErrorResponse> handleCorreoRegistradoException(CorreoRegistradoException e) {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setMensaje(e.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(ClaveInvalidaException.class)
    public ResponseEntity<ErrorResponse> handleClaveInvalidaException(ClaveInvalidaException e) {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setMensaje(e.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(CorreoInvalidoException.class)
    public ResponseEntity<ErrorResponse> handleCorreoInvalidoException(CorreoInvalidoException e) {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setMensaje(e.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }
}