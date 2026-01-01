package com.oceanLink.repository;

import com.oceanLink.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PaymentRepo extends JpaRepository<Payment,Long> {

    Payment findByBooking_BookingId(Long id);

    List<Payment> findByBooking_User_UserId(Long id);

}
