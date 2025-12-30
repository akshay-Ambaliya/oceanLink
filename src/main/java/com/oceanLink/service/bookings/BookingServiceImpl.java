package com.oceanLink.service.bookings;

import com.oceanLink.dto.Booking.BookingDTO;
import com.oceanLink.exception.Booking.BookingNotFoundException;
import com.oceanLink.exception.User.UserNotFoundException;
import com.oceanLink.model.Booking;
import com.oceanLink.model.Schedules;
import com.oceanLink.model.User;
import com.oceanLink.repository.BookingRepo;
import com.oceanLink.repository.ScheduleRepo;
import com.oceanLink.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingServiceImpl implements BookingService{

    @Autowired
    BookingRepo bookingRepo;

    @Autowired
    UserRepo userRepo;

    @Autowired
    ScheduleRepo schedulesRepo;

    @Override
    public Booking createBooking(BookingDTO dto) {
        User user =userRepo.findById(dto.getUserId()).orElseThrow(()->new UserNotFoundException(dto.getUserId()));
        Schedules schedule =schedulesRepo.findById(dto.getUserId()).orElseThrow(()->new UserNotFoundException(dto.getUserId()));

        Booking booking =  new Booking();
        booking.setBookingDate(dto.getDate());
        booking.setBookingStatus(dto.getBookingStatus());
        booking.setUser(user);
        booking.setSchedules(schedule);

        return bookingRepo.save(booking);
    }

    @Override
    public Booking getBookingByID(long id) {
        return bookingRepo.findById(id).orElseThrow(()->new BookingNotFoundException(id));
    }

    @Override
    public List<Booking> getAllBooking() {
        return bookingRepo.findAll();
    }

    @Override
    public List<Booking> getAllBookingByUser(Long id) {

            if(!userRepo.existsById(id))
                throw new UserNotFoundException(id);

            return bookingRepo.findByUser_UserId(id);

    }

    @Override
    public Booking cancelBooking(long id) {

        Booking booking = bookingRepo.findById(id).orElseThrow(()->new RuntimeException("Booking Not Found"));

        if("CANCELLED".equals(booking.getBookingStatus())){
            throw new RuntimeException("Booking Already Cancelled");
        }
        if("COMPLETED".equals(booking.getBookingStatus())){
            throw new RuntimeException("Completed booking Cannot be cancelled");
        }

        booking.setBookingStatus("CANCELLED");

        return bookingRepo.save(booking);

    }
}
