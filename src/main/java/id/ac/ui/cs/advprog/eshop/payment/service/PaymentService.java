package id.ac.ui.cs.advprog.eshop.payment.service;

import java.util.List;
import java.util.Map;

import id.ac.ui.cs.advprog.eshop.order.model.Order;
import id.ac.ui.cs.advprog.eshop.payment.model.Payment;

public interface PaymentService {
    Payment addPayment(Order order, String method, Map<String, String> paymentData);
    Payment setStatus(String paymentId, String status);
    Payment getPayment(String paymentId);
    List<Payment> getAllPayments();
}
