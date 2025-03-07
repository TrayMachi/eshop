package id.ac.ui.cs.advprog.eshop.payment.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import id.ac.ui.cs.advprog.eshop.payment.model.Payment;
import id.ac.ui.cs.advprog.eshop.payment.repository.PaymentRepository;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    @Override
    public Payment addPayment(Payment payment) {
        if (paymentRepository.findById(payment.getId()) == null & paymentRepository.findAllByOrderId(payment.getOrder().getId()) == null) {
            return paymentRepository.save(payment);
        }

        return null;
    }

    @Override
    public Payment setStatus(String paymentId, String status) {
        Payment payment = paymentRepository.findById(paymentId);
        if (payment != null) {
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
