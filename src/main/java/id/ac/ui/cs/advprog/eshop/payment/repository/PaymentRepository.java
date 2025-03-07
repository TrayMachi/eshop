package id.ac.ui.cs.advprog.eshop.payment.repository;

import java.util.ArrayList;
import java.util.List;

import id.ac.ui.cs.advprog.eshop.payment.model.Payment;

public class PaymentRepository {
    private List<Payment> paymentData = new ArrayList<>();

    public Payment save(Payment payment) {
        int i = 0;
        for (Payment savedPayment : paymentData) {
            if (savedPayment.getId().equals(payment.getId())) {
                paymentData.remove(i);
                paymentData.add(i, payment);
                return payment;
            }
            i++;
        }

        paymentData.add(payment);
        return payment;
    }

    public List<Payment> findAll() {
        return paymentData;
    }

    public Payment findById(String id) {
        for (Payment savedPayment : paymentData) {
            if (savedPayment.getId().equals(id)) {
                return savedPayment;
            }
        }
        return null;
    }

    public Payment findAllByOrderId(String orderId) {
        for (Payment savedPayment : paymentData) {
            if (savedPayment.getOrder().getId().equals(orderId)) {
                return savedPayment;
            }
        }
        return null;
    }
}
