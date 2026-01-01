package com.oceanLink.service.ticket;

import com.oceanLink.dto.ticket.TicketDTO;
import com.oceanLink.model.Ticket;

public interface TicketService {

    Ticket generateTicket(TicketDTO ticket);

    Ticket getTicketById(Long id);

    Ticket getTicketByBooking(Long id);
}
