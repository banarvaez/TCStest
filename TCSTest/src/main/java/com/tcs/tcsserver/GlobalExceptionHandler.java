package com.tcs.tcsserver;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String manejarExcepcion(RuntimeException ex) {
        return ex.getMessage(); // En este caso retornará “Saldo no disponible” si esa es la excepción lanzada.
    }
}

