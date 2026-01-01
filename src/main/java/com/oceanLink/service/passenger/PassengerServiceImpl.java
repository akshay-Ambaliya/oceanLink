package com.oceanLink.service.passenger;

import com.oceanLink.dto.passenger.PassengerDTO;
import com.oceanLink.exception.Booking.BookingNotFoundException;
import com.oceanLink.exception.Passenger.PassengerNotFoundException;
import com.oceanLink.model.Booking;
import com.oceanLink.model.Passenger;
import com.oceanLink.repository.BookingRepo;
import com.oceanLink.repository.PassengerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PassengerServiceImpl implements PassengerService{

    @Autowired
    BookingRepo bookingRepo;

    @Autowired
    PassengerRepo passengerRepo;

    @Override
    public Passenger addPassenger(PassengerDTO p) {
        Booking booking = bookingRepo.findById(p.getBookingId()).orElseThrow(()->new BookingNotFoundException(p.getBookingId()));
        Passenger pass = new Passenger();
        pass.setAge(p.getAge());
        pass.setName(p.getName());
        pass.setGender(p.getGender());
        pass.setIdProof(p.getIdProof());
        pass.setBooking(booking);

        return passengerRepo.save(pass);
    }

    @Override
    public List<Passenger> getPassengersByBookingId(Long bookingId) {
        if(bookingRepo.existsById(bookingId)){
            return passengerRepo.findByBooking_BookingId(bookingId);
        }else {
            throw new BookingNotFoundException(bookingId);
        }
    }

    @Override
    public Passenger getPassengerById(Long passengerId) {
        return passengerRepo.findById(passengerId).orElseThrow(()->new PassengerNotFoundException(passengerId));
    }

    @Override
    public Passenger updatePassenger(Long passengerId, PassengerDTO dto) {
        Passenger pass = passengerRepo.findById(passengerId).orElseThrow(()->new PassengerNotFoundException(passengerId));
        pass.setName(dto.getName());
        pass.setAge(dto.getAge());
        pass.setGender(dto.getGender());
        pass.setIdProof(dto.getIdProof());

        return passengerRepo.save(pass);
    }

    @Override
    public void deletePassenger(Long passengerId) {
        if(passengerRepo.existsById(passengerId))
            passengerRepo.deleteById(passengerId);
        else
            throw new PassengerNotFoundException(passengerId);
    }
}
