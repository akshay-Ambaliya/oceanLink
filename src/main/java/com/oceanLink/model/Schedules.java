package com.oceanLink.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
@Entity
public class Schedules {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long schedule_id;

    @ManyToOne
    @JoinColumn(name="ship_id")
    private Ship ship;

    @ManyToOne
    @JoinColumn(name="route_id")
    private Route route;

    private String departure;

    private String arrival;

    private int price;
}


