package com.oceanLink.service.payment;

import com.oceanLink.dto.payment.PaymentDTO;
import com.oceanLink.exception.Booking.BookingNotFoundException;
import com.oceanLink.exception.Payment.PaymentNotFoundException;
import com.oceanLink.model.Booking;
import com.oceanLink.model.Payment;
import com.oceanLink.repository.BookingRepo;
import com.oceanLink.repository.PaymentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    PaymentRepo paymentRepo;

    @Autowired
    BookingRepo bookingRepo;
    @Override
    public Payment makePayment(PaymentDTO dto) {

        Booking booking = bookingRepo.findById(dto.getBookingId()).orElseThrow(()->new BookingNotFoundException(dto.getBookingId()));

        Payment payment = new Payment();
        payment.setPaymentDate(dto.getPaymentDate());
        payment.setAmount(dto.getAmount());
        payment.setMode(dto.getMode());
        payment.setBooking(booking);

        return paymentRepo.save(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentRepo.findById(id).orElseThrow(()->new PaymentNotFoundException(id));
    }

    @Override
    public Payment getPaymentByBookingId(Long id) {
        if(!bookingRepo.existsById(id)){
            throw new BookingNotFoundException(id);
        }

        return paymentRepo.findByBooking_BookingId(id);
    }

    @Override
    public List<Payment> getPaymentHistory(Long userId) {
        return paymentRepo.findByBooking_User_UserId(userId);
    }
}
