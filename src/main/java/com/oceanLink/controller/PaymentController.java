package com.oceanLink.controller;

import com.oceanLink.dto.payment.PaymentDTO;
import com.oceanLink.model.Payment;
import com.oceanLink.service.payment.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/payments")
public class PaymentController {

    @Autowired
    PaymentService service;

    @PostMapping
    public ResponseEntity<Payment> makePayment(@RequestBody PaymentDTO dto){
        return ResponseEntity.ok(service.makePayment(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Payment> GetPaymentById(@PathVariable Long id){
        return ResponseEntity.ok(service.getPaymentById(id));
    }

    @GetMapping("/booking/{bookingId}")
    public ResponseEntity<Payment> GetPaymentByBooking(@PathVariable Long bookingId){
        return ResponseEntity.ok(service.getPaymentByBookingId(bookingId));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Payment>> getPaymentHistory(@PathVariable Long userId){
        return ResponseEntity.ok(service.getPaymentHistory(userId));
    }
}
