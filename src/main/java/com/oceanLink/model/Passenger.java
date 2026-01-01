package com.oceanLink.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@Entity
public class Passenger {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long passangerId;

    private String name;

    private int age;

    private String gender;

    private String idProof;

    @ManyToOne
    @JoinColumn(name="booking_id")
    private Booking booking;

}
