package com.oceanLink.dto.ticket;

import com.oceanLink.model.Booking;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TicketDTO {
    private Long bookingId;
    private Long ticketNumber;
    private LocalDate issue_Date;
    private String status;
}
