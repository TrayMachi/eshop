package id.ac.ui.cs.advprog.eshop.payment.model;

import java.util.Map;

import id.ac.ui.cs.advprog.eshop.order.model.Order;
import id.ac.ui.cs.advprog.eshop.payment.enums.PaymentMethod;
import id.ac.ui.cs.advprog.eshop.payment.enums.PaymentStatus;
import id.ac.ui.cs.advprog.eshop.utils.ModelAbstract.ModelAbstract;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter @Builder @Setter
public class Payment extends ModelAbstract {
    private Order order;
    private String method;
    private String status;
    private Map<String, String> paymentData;

    public Payment(Order order, String method, Map<String, String> paymentData) {
        super();
        this.order = order;
        this.method = method;
        this.setStatus("WAITING_PAYMENT");
        this.setPaymentMethod(method);
        this.paymentData = paymentData;
        PaymentDataVerification(paymentData);
    }

    public Payment(Order order, String method, String status, Map<String, String> paymentData) {
        super();
        this.order = order;
        this.method = method;
        this.setStatus(status);
        this.setPaymentMethod(method);
    }

    private boolean PaymentDataVerification(Map<String, String> paymentData) {
        if (this.method.equals("VOUCHERCODE")) {
            return validateVoucherCode(paymentData);
        } else if (this.method.equals("BANKTRANSFER")) {
            return validateBankTransfer(paymentData);
        }

        return false;
    }

    private boolean validateVoucherCode(Map<String, String> paymentData) {
        String voucherCode = paymentData.get("voucherCode");

        if (voucherCode != null && voucherCode.length() == 16 && voucherCode.startsWith("ESHOP") && voucherCode.substring(5).matches("\\d{8}")) {
            this.status = PaymentStatus.SUCCESS.getValue();
            order.setStatus("SUCCESS");
            return true;
        } else {
            this.status = PaymentStatus.REJECTED.getValue();
            order.setStatus("FAILED");
            return false;

        }
    }

    private boolean validateBankTransfer(Map<String, String> paymentData) {
        String bankName = paymentData.get("bankName");
        String referenceCode = paymentData.get("accountNumber");

        if (bankName != null && referenceCode != null) {
            this.status = PaymentStatus.SUCCESS.getValue();
            order.setStatus("SUCCESS");
            return true;
        } else {
            this.status = PaymentStatus.REJECTED.getValue();
            order.setStatus("FAILED");
            return false;
        }

    }
    
    public void setStatus(String status) {
        if (PaymentStatus.contains(status)) {
            this.status = status;
        } else {
            throw new IllegalArgumentException();
        }
    }

    public void setPaymentMethod(String paymentMethod) {
        if (PaymentMethod.contains(paymentMethod)) {
            this.method = paymentMethod;
        } else {
            throw new IllegalArgumentException();
        }
    }

}
