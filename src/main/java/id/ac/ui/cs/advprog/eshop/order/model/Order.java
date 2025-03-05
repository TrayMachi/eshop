package id.ac.ui.cs.advprog.eshop.order.model;

import java.util.List;

import id.ac.ui.cs.advprog.eshop.product.model.Product;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter @Builder
public class Order {
    String id;
    List<Product> products;
    long orderTime;
    String author;
    @Setter
    String status;

    public Order(String id, List<Product> products, long orderTime, String author) {
    }

    public Order(String id, List<Product> products, long orderTime, String author, String status) {
    }
}
