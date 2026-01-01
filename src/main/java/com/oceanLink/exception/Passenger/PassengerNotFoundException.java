package com.oceanLink.exception.Passenger;

public class PassengerNotFoundException extends RuntimeException{
    public PassengerNotFoundException(Long id){
        super("Could not found passenger with Id "+id);
    }
}
