package com.oceanLink.exception.Route;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

public class RouteNotFoundException extends RuntimeException {
    public RouteNotFoundException(long id){
        super("Route not found with id : "+id);
    }
}
