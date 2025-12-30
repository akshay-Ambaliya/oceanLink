package com.oceanLink.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Booking {

    @Column(name="booking_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookingId;

    private String bookingStatus;

    private LocalDate bookingDate;

    @ManyToOne
    @JoinColumn(name = "schedule_id")
    private Schedules schedules;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

}
