package id.ac.ui.cs.advprog.eshop.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import id.ac.ui.cs.advprog.eshop.order.enums.OrderStatus;
import id.ac.ui.cs.advprog.eshop.order.model.Order;
import id.ac.ui.cs.advprog.eshop.payment.enums.PaymentMethod;
import id.ac.ui.cs.advprog.eshop.payment.enums.PaymentStatus;
import id.ac.ui.cs.advprog.eshop.payment.model.Payment;
import id.ac.ui.cs.advprog.eshop.product.model.Product;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class PaymentTest {
    private Payment payment;
    private Order order;
    private Map<String, String> paymentData;

    @BeforeEach
    void setUp() {
        List<Product> products = new ArrayList<>();
        Product product = new Product();
        product.setId("1b709a33-4da3-4cbd-abd1-dc4dd3d855eb");
        product.setProductName("Sampo Cap Bambang");
        product.setProductQuantity(2);
        products.add(product);

        order = new Order("f423148a-a11f-4865-9744-60ade538c37b", products,
                System.currentTimeMillis(), "Tray", OrderStatus.WAITING_PAYMENT.getValue());

        paymentData = new HashMap<>();
        paymentData.put("voucherCode", "ESHOP12345678ABC");

        payment = new Payment(order, "VOUCHERCODE", paymentData);
    }

    @Test
    void testPaymentCreation() {
        assertEquals(order, payment.getOrder());
        assertEquals(PaymentMethod.VOUCHERCODE.getValue(), payment.getMethod());
        assertEquals(PaymentStatus.REJECTED.getValue(), payment.getStatus());
        assertEquals(paymentData, payment.getPaymentData());
    }

    @Test
    void testPaymentCreationVoucherFailed() {
        Map<String, String> paymentData = new HashMap<>();
        paymentData.put("voucherCode", "ESHOP123456789ABC");
        Payment payment = new Payment(order,
                PaymentMethod.VOUCHERCODE.getValue(), paymentData);
        assertEquals(order, payment.getOrder());
        assertEquals(PaymentMethod.VOUCHERCODE.getValue(), payment.getMethod());
        assertEquals(PaymentStatus.REJECTED.getValue(), payment.getStatus());
        assertNull(payment.getPaymentData());
    }

    @Test
    void testPaymentCreationVoucherNull() {
        Payment payment = new Payment(order,
                PaymentMethod.VOUCHERCODE.getValue(), null);
        assertEquals(order, payment.getOrder());
        assertEquals(PaymentMethod.VOUCHERCODE.getValue(), payment.getMethod());
        assertEquals(PaymentStatus.REJECTED.getValue(), payment.getStatus());
        assertNull(payment.getPaymentData());
    }

    @Test
    void testPaymentCreationOrderNull() {
        Map<String, String> paymentData = new HashMap<>();
        paymentData.put("voucherCode", "ESHOP123456789ABC");

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Payment(null,
                    PaymentMethod.VOUCHERCODE.getValue(), paymentData);
        });

        assertEquals("order is null", exception.getMessage());
    }


    @Test
    void testSetMethod() {
        payment.setPaymentMethod(PaymentMethod.BANKTRANSFER.getValue());
        assertEquals(PaymentMethod.BANKTRANSFER.getValue(), payment.getMethod());
    }

    @Test
    void testSetStatus() {
        payment.setStatus(PaymentStatus.REJECTED.getValue());
        assertEquals(PaymentStatus.REJECTED.getValue(), payment.getStatus());
    }

    @Test
    void testInvalidVoucherCode() {
        Map<String, String> invalidVoucherData = new HashMap<>();
        invalidVoucherData.put("voucherCode", "INVALID12345");

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            payment.setPaymentData(invalidVoucherData);
        });

        assertEquals("paymentData is not valid", exception.getMessage());
        assertEquals("ESHOP12345678ABC", payment.getPaymentData().get("voucherCode"));
    }

    @Test
    void testEmptyVoucherCode() {
        Map<String, String> emptyVoucherData = new HashMap<>();
        emptyVoucherData.put("voucherCode", "");

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            payment.setPaymentData(emptyVoucherData);
        });

        assertEquals("paymentData is not valid", exception.getMessage());
        assertEquals("ESHOP12345678ABC", payment.getPaymentData().get("voucherCode"));
    }

    @Test
    void testNullVoucherCode() {
        Map<String, String> nullVoucherData = new HashMap<>();
        nullVoucherData.put("voucherCode", null);

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            payment.setPaymentData(nullVoucherData);
        });

        assertEquals("paymentData is not valid", exception.getMessage());
        assertEquals("ESHOP12345678ABC", payment.getPaymentData().get("voucherCode"));
    }

    @Test
    void testVoucherThatDoesNotStartWithESHOP() {
        Map<String, String> invalidVoucherData = new HashMap<>();
        invalidVoucherData.put("voucherCode", "SHOP1234567890AB");

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            payment.setPaymentData(invalidVoucherData);
        });

        assertEquals("paymentData is not valid", exception.getMessage());
        assertEquals("ESHOP12345678ABC", payment.getPaymentData().get("voucherCode"));
    }

    @Test
    void testVoucherShorterThan16Characters() {
        Map<String, String> invalidVoucherData = new HashMap<>();
        invalidVoucherData.put("voucherCode", "ESHOP12345");

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            payment.setPaymentData(invalidVoucherData);
        });

        assertEquals("paymentData is not valid", exception.getMessage());
        assertEquals("ESHOP12345678ABC", payment.getPaymentData().get("voucherCode"));
    }

    @Test
    void testVoucherLongerThan16Characters() {
        Map<String, String> invalidVoucherData = new HashMap<>();
        invalidVoucherData.put("voucherCode", "ESHOP12345678901234");

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            payment.setPaymentData(invalidVoucherData);
        });

        assertEquals("paymentData is not valid", exception.getMessage());
        assertEquals("ESHOP12345678ABC", payment.getPaymentData().get("voucherCode"));
    }

    @Test
    void testVoucherWithLessThan8Numbers() {
        Map<String, String> invalidVoucherData = new HashMap<>();
        invalidVoucherData.put("voucherCode", "ESHOP123ABCDEFGHI");

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            payment.setPaymentData(invalidVoucherData);
        });

        assertEquals("paymentData is not valid", exception.getMessage());
        assertEquals("ESHOP12345678ABC", payment.getPaymentData().get("voucherCode"));
    }

    @Test
    void testVoucherWithMoreThan8Numbers() {
        Map<String, String> invalidVoucherData = new HashMap<>();
        invalidVoucherData.put("voucherCode", "ESHOP1234567890A");

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            payment.setPaymentData(invalidVoucherData);
        });

        assertEquals("paymentData is not valid", exception.getMessage());
        assertEquals("ESHOP12345678ABC", payment.getPaymentData().get("voucherCode"));
    }

    @Test
    void testVoucherCodeWithLowerCasePrefix() {
        Map<String, String> invalidVoucherData = new HashMap<>();
        invalidVoucherData.put("voucherCode", "eshop12345678ABCD");

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            payment.setPaymentData(invalidVoucherData);
        });

        assertEquals("paymentData is not valid", exception.getMessage());
        assertEquals("ESHOP12345678ABC", payment.getPaymentData().get("voucherCode"));
    }

    @Test
    void testBankTransferConstructorWithMissingBankName() {
        Map<String, String> invalidBankData = new HashMap<>();
        invalidBankData.put("referenceCode", "REF123456789");

        Payment payment = new Payment(order,
                PaymentMethod.BANKTRANSFER.getValue(), invalidBankData);

        assertEquals(PaymentStatus.REJECTED.getValue(), payment.getStatus());
        assertNull(payment.getPaymentData());
    }

    @Test
    void testBankTransferConstructorWithMissingReferenceCode() {
        Map<String, String> invalidBankData = new HashMap<>();
        invalidBankData.put("bankName", "BCA");

        Payment payment = new Payment(order,
                PaymentMethod.BANKTRANSFER.getValue(), invalidBankData);

        assertEquals(PaymentStatus.REJECTED.getValue(), payment.getStatus());
        assertNull(payment.getPaymentData());
    }

    @Test
    void testBankTransferConstructorWithNullData() {
        Map<String, String> invalidBankData = new HashMap<>();
        invalidBankData.put("bankName", null);
        invalidBankData.put("referenceCode", null);

        Payment payment = new Payment(order,
                PaymentMethod.BANKTRANSFER.getValue(), invalidBankData);

        assertEquals(PaymentStatus.REJECTED.getValue(), payment.getStatus());
        assertNull(payment.getPaymentData());
    }

    @Test
    void testBankTransferConstructorWithEmptyData() {
        Map<String, String> invalidBankData = new HashMap<>();
        invalidBankData.put("bankName", "");
        invalidBankData.put("referenceCode", "");

        Payment payment = new Payment(order,
                PaymentMethod.BANKTRANSFER.getValue(), invalidBankData);

        assertEquals(PaymentStatus.REJECTED.getValue(), payment.getStatus());
        assertNull(payment.getPaymentData());
    }

    @Test
    void testValidBankTransferPayment() {
        Map<String, String> validBankData = new HashMap<>();
        validBankData.put("bankName", "BCA");
        validBankData.put("referenceCode", "REF123456789");

        Payment payment = new Payment(order,
                PaymentMethod.BANKTRANSFER.getValue(), validBankData);

        assertEquals(PaymentStatus.SUCCESS.getValue(), payment.getStatus());
        assertEquals(validBankData, payment.getPaymentData());
    }
}