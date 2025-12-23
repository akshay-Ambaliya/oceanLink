package com.oceanLink.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Route {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long route_id;
    private String source;
    private String destination;
    private int distance;
    private int duration;

}
