package com.oceanLink.controller;

import com.oceanLink.dto.ticket.TicketDTO;
import com.oceanLink.model.Ticket;
import com.oceanLink.service.ticket.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ticket")
public class TicketController {

    @Autowired
    TicketService service;

    @PostMapping
    public ResponseEntity<Ticket> generateTicket(@RequestBody TicketDTO dto){
        return ResponseEntity.ok(service.generateTicket(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ticket> getTicketById(@PathVariable Long id){
        return ResponseEntity.ok(service.getTicketById(id));
    }

    @GetMapping("/booking/{bookingId}")
    public ResponseEntity<Ticket> getTicketByBookingId(@PathVariable Long bookingId) {
        return ResponseEntity.ok(service.getTicketByBooking(bookingId));
    }
}
