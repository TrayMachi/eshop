package id.ac.ui.cs.advprog.eshop.payment.service;

import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import id.ac.ui.cs.advprog.eshop.order.model.Order;
import id.ac.ui.cs.advprog.eshop.payment.model.Payment;
import id.ac.ui.cs.advprog.eshop.payment.repository.PaymentRepository;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    @Override
    public Payment addPayment(Order order, String method, Map<String, String> paymentData) {
        if (paymentRepository.findAllByOrderId(order.getId()) == null) {
            Payment payment = new Payment(order, method, paymentData);
            paymentRepository.save(payment);
            return payment;
        }

        return null;
    }

    @Override
    public Payment setStatus(String paymentId, String status) {
        Payment payment = paymentRepository.findById(paymentId);
        if (payment != null) {
            if (status.equals("SUCCESS")) {
                payment.getOrder().setStatus("SUCCESS");
            } else {
                payment.getOrder().setStatus("FAILED");
            }
            Payment newPayment = new Payment(payment.getOrder(), payment.getMethod(), status, payment.getPaymentData());
            paymentRepository.save(newPayment);
            return newPayment;
        } else {
            throw new NoSuchElementException();
        }
    }

    @Override
    public Payment getPayment(String paymentId) {
        return paymentRepository.findById(paymentId);
    }

    @Override
    public List<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }
    
}
