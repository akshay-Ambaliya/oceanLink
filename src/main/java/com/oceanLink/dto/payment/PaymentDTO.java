package com.oceanLink.dto.payment;

import com.oceanLink.model.Booking;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
public class PaymentDTO {
    private Long bookingId;

    private int amount;

    private LocalDate paymentDate;

    private String mode;
}
