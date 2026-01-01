package com.oceanLink.service.payment;

import com.oceanLink.dto.payment.PaymentDTO;
import com.oceanLink.model.Payment;

import java.util.List;

public interface PaymentService {

    Payment makePayment(PaymentDTO dto);

    Payment getPaymentById(Long id);

    Payment getPaymentByBookingId(Long id);

    List<Payment> getPaymentHistory(Long userId);

}
