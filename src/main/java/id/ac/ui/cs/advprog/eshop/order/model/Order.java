package id.ac.ui.cs.advprog.eshop.order.model;

import java.util.Arrays;
import java.util.List;

import id.ac.ui.cs.advprog.eshop.product.model.Product;
import lombok.Builder;
import lombok.Getter;

@Getter @Builder
public class Order {
    String id;
    List<Product> products;
    long orderTime;
    String author;
    String status;

    public Order(String id, List<Product> products, long orderTime, String author) {
        this.id = id;
        this.orderTime = orderTime;
        this.author = author;
        this.status = "WAITING_PAYMENT";

        if (products.isEmpty()) {
            throw new IllegalArgumentException();
        } else {
            this.products = products;
        }

    }

    public Order(String id, List<Product> products, long orderTime, String author, String status) {
        this(id, products, orderTime, author);
        setStatus(status);
    }

    public void setStatus(String status) {
        String[] statusList = {"WAITING_PAYMENT", "FAILED", "SUCCESS", "CANCELLED"};
        if (Arrays.stream(statusList).noneMatch(item -> (item.equals(status)))) {
            throw new IllegalArgumentException();
        } else {
            this.status = status;
        }
    }
}
