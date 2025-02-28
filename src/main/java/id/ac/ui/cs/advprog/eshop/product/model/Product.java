package id.ac.ui.cs.advprog.eshop.product.model;

import java.util.UUID;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Product {
    private String productId;
    private String productName;
    private int productQuantity;
    
    public Product() {
        this.productId = UUID.randomUUID().toString();
    }
}
