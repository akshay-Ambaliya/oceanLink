package com.oceanLink.exception.Ticket;

public class TicketNotFoundException extends RuntimeException{
    public TicketNotFoundException(Long id){
        super("Ticket not found with ID : "+id);
    }
}
