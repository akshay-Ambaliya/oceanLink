package com.oceanLink.controller;

import com.oceanLink.dto.Booking.BookingDTO;
import com.oceanLink.model.Booking;
import com.oceanLink.service.bookings.BookingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Book;
import java.util.List;

@RestController
@RequestMapping("/bookings")
public class BookingController {

    @Autowired
    BookingService service;

    @PostMapping
    public ResponseEntity<Booking> createBooking(@RequestBody BookingDTO dto){
        return ResponseEntity.ok(service.createBooking(dto));
    }

    @GetMapping
    public ResponseEntity<List<Booking>> getAllBooking(){
        List<Booking> bookings = service.getAllBooking();
        if(bookings.isEmpty())
            return ResponseEntity.noContent().build();
        else
            return ResponseEntity.ok(bookings);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Booking> getBookingById(@PathVariable Long id)
    {
        return ResponseEntity.ok(service.getBookingByID(id));
    }

    @GetMapping("user/{id}")
    public ResponseEntity<List<Booking>> getAllBookingByUser(@PathVariable Long id)
    {
        List<Booking> bookings = service.getAllBookingByUser(id);
        if(bookings.isEmpty())
            return ResponseEntity.noContent().build();
        else
            return ResponseEntity.ok(bookings);
    }

    @PatchMapping("/{id}/cancel")
    public ResponseEntity<Booking> cancelBooking(@PathVariable Long id){
        Booking cancelledBooking = service.cancelBooking(id);
        return ResponseEntity.ok(cancelledBooking);
    }
}
