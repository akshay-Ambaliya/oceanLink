package com.oceanLink.exception.Payment;

public class PaymentNotFoundException extends RuntimeException{
    public PaymentNotFoundException(Long id){
        super("Payment not found with Id : "+id);
    }
}
