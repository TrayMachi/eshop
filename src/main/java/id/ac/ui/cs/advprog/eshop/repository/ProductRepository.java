package id.ac.ui.cs.advprog.eshop.repository;


import id.ac.ui.cs.advprog.eshop.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Repository
public class ProductRepository {
    private List<Product> productData = new ArrayList<>();
    
    public Iterator<Product> findAll() {
        return productData.iterator();
    }

    public Product findById(String productId) {
        for (Product p : productData) {
            if (p.getProductId().equals(productId)) {
                return p;
            }
        }
        return null;
    }

    public Product create(Product product) {
        productData.add(product);
        return product;
    }

    public Product edit(Product product) {
        for (Product p : productData) {
            if (p.getProductId().equals(product.getProductId())) {
                p.setProductName(product.getProductName());
                p.setProductQuantity(product.getProductQuantity());
                break;
            }
        }
        return product;
    }

    public boolean delete(Product product) {
        return productData.remove(product);
    }
}
