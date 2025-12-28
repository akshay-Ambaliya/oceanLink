package com.oceanLink.exception;

import com.oceanLink.exception.Route.RouteNotFoundException;
import com.oceanLink.exception.Ship.ShipNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RouteNotFoundException.class)
    public ResponseEntity<?> handleRouteNotFound(RouteNotFoundException ex){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                Map.of(
                        "sucess",false,
                        "message",ex.getMessage()
                )
        );
    }

    @ExceptionHandler(ShipNotFoundException.class)
    public ResponseEntity<?> handelShipNotFound(ShipNotFoundException ex){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                Map.of(
                        "sucess",false,
                        "message",ex.getMessage()
                )
        );
    }
}
