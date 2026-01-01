package com.oceanLink.dto.passenger;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
public class PassengerDTO {

    private Long passenger_id;
    private String name;
    private int age;
    private String gender;
    private String idProof;
    private Long bookingId;

}
