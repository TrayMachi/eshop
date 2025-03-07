package id.ac.ui.cs.advprog.eshop.payment.service;

import id.ac.ui.cs.advprog.eshop.payment.model.Payment;

public interface PaymentService {
    Payment addPayment(Payment payment);
    Payment setStatus(String paymentId, String status);
    Payment getPayment(String paymentId);
    Payment getAllPayments();
}
