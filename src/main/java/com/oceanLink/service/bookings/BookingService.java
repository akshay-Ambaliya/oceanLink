package com.oceanLink.service.bookings;

import com.oceanLink.dto.Booking.BookingDTO;
import com.oceanLink.model.Booking;

import java.util.List;

public interface BookingService {
    Booking createBooking(BookingDTO dto);

    Booking getBookingByID(long id);

    List<Booking> getAllBooking();

    List<Booking> getAllBookingByUser(Long id);

    Booking cancelBooking(long id);

}
