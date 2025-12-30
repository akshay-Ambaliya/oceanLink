package com.oceanLink.exception.Booking;

import java.awt.print.Book;

public class BookingNotFoundException extends RuntimeException{
    public BookingNotFoundException(long id)
    {
        super("Booking Not Found With Id : "+id);
    }
}
