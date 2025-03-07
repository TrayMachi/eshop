package id.ac.ui.cs.advprog.eshop.payment.service;

import java.util.List;

import id.ac.ui.cs.advprog.eshop.payment.model.Payment;

public interface PaymentService {
    Payment addPayment(Payment payment);
    Payment setStatus(String paymentId, String status);
    Payment getPayment(String paymentId);
    List<Payment> getAllPayments();
}
