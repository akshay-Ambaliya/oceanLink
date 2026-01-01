package com.oceanLink.service.passenger;

import com.oceanLink.dto.passenger.PassengerDTO;
import com.oceanLink.model.Passenger;

import java.util.List;

public interface PassengerService {
    Passenger addPassenger (PassengerDTO p);

    List<Passenger> getPassengersByBookingId(Long bookingId);

    Passenger getPassengerById(Long passengerId);

    Passenger updatePassenger(Long PassengerId,PassengerDTO passenger);

    void deletePassenger(Long passengerId);
}
