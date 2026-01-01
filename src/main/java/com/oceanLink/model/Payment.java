package com.oceanLink.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long paymentId;

    @OneToOne
    @JoinColumn(name="booking_id")
    private Booking booking;

    private int amount;

    private LocalDate paymentDate;

    private String mode;

}
