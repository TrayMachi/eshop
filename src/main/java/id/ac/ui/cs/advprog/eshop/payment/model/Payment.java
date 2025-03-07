package id.ac.ui.cs.advprog.eshop.payment.model;

import java.util.Map;

import id.ac.ui.cs.advprog.eshop.payment.enums.PaymentMethod;
import id.ac.ui.cs.advprog.eshop.payment.enums.PaymentStatus;
import id.ac.ui.cs.advprog.eshop.utils.ModelAbstract.ModelAbstract;
import lombok.Getter;

@Getter
public class Payment extends ModelAbstract {
    private String method;
    private String status;
    private Map<String, String> paymentData;

    public Payment(String method, String status, Map<String, String> paymentData) {
        super();
        this.paymentData = paymentData;
        this.setStatus(status);
        this.setPaymentMethod(method);
    }
    
    public void setStatus(String status) {
        if (PaymentStatus.contains(status)) {
            this.status = status;
        } else {
            throw new IllegalArgumentException();
        }
    }

    public void setPaymentMethod(String status) {
        if (PaymentMethod.contains(status)) {
            this.status = status;
        } else {
            throw new IllegalArgumentException();
        }
    }

}
