package com.oceanLink.repository;

import com.oceanLink.model.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PassengerRepo extends JpaRepository<Passenger,Long> {

    List<Passenger> findByBooking_BookingId(Long id);

}
