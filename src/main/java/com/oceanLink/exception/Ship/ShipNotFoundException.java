package com.oceanLink.exception.Ship;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

public class ShipNotFoundException extends RuntimeException{
    public ShipNotFoundException(long id){
        super("Ship not found with id : "+id);
    }
}
