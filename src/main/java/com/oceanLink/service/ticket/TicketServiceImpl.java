package com.oceanLink.service.ticket;

import com.oceanLink.dto.ticket.TicketDTO;
import com.oceanLink.exception.Booking.BookingNotFoundException;
import com.oceanLink.exception.Ticket.TicketNotFoundException;
import com.oceanLink.model.Booking;
import com.oceanLink.model.Ticket;
import com.oceanLink.repository.BookingRepo;
import com.oceanLink.repository.TicketRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TicketServiceImpl implements TicketService{

    @Autowired
    public BookingRepo bookingRepo;

    @Autowired
    public TicketRepo ticketRepo;

    @Override
    public Ticket generateTicket(TicketDTO dto) {
        Booking booking = bookingRepo.findById(dto.getBookingId()).orElseThrow(()->new BookingNotFoundException(dto.getBookingId()));

        Ticket ticket = new Ticket();

        ticket.setTicketNumber(dto.getTicketNumber());
        ticket.setBooking(booking);
        ticket.setIssue_Date(dto.getIssue_Date());
        ticket.setStatus(dto.getStatus());

        return ticketRepo.save(ticket);
    }

    @Override
    public Ticket getTicketById(Long id) {
        return ticketRepo.findById(id).orElseThrow(()->new TicketNotFoundException(id));
    }

    @Override
    public Ticket getTicketByBooking(Long id) {
        if(!bookingRepo.existsById(id))
            throw new BookingNotFoundException(id);

        return ticketRepo.findByBooking_BookingId(id);
    }
}
