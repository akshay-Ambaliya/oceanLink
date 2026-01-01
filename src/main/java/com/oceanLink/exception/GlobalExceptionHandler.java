package com.oceanLink.exception;

import com.oceanLink.exception.Booking.BookingNotFoundException;
import com.oceanLink.exception.Passenger.PassengerNotFoundException;
import com.oceanLink.exception.Route.RouteNotFoundException;
import com.oceanLink.exception.Ship.ShipNotFoundException;
import com.oceanLink.exception.User.UserNotFoundException;
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
                        "success",false,
                        "message",ex.getMessage()
                )
        );
    }

    @ExceptionHandler(ShipNotFoundException.class)
    public ResponseEntity<?> handelShipNotFound(ShipNotFoundException ex){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                Map.of(
                        "success",false,
                        "message",ex.getMessage()
                )
        );
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<?> handleUserNotFound(UserNotFoundException ex){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                Map.of(
                        "success",false,
                        "message",ex.getMessage()
                )
        );
    }

    @ExceptionHandler(BookingNotFoundException.class)
    public ResponseEntity<?> handleBookingNotFoundException(BookingNotFoundException ex){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
            Map.of(
                    "success",false,
                    "message",ex.getMessage()
            )
        );
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<?> RunTimExceptionHandeler(RuntimeException ex){
        return ResponseEntity.status(HttpStatus.CONFLICT).body(
                Map.of(
                        "success",false,
                        "message",ex.getMessage()
                )
        );
    }

    @ExceptionHandler(PassengerNotFoundException.class)
    public ResponseEntity<?> PassengerNotFoundException(PassengerNotFoundException ex)
    {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                Map.of(
                    "status",404,
                    "message",ex.getMessage()
                )
        );
    }
}
