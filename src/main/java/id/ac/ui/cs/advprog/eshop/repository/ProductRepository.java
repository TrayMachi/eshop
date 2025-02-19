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
        if (productId == null) {
            return null;
        }
        return productData.stream()
                .filter(p -> productId.equals(p.getProductId()))
                .findFirst()
                .orElse(null);
    }

    public Product create(Product product) {
        productData.add(product);
        return product;
    }

    public Product edit(Product product) {
        if (product == null) {
            return null;
        }

        Product existingProduct = findById(product.getProductId());
        if (existingProduct == null) {
            return null;
        }

        existingProduct.setProductName(product.getProductName());
        existingProduct.setProductQuantity(product.getProductQuantity());
        return existingProduct;
    }

    public boolean delete(Product product) {
        return productData.remove(product);
    }
}
