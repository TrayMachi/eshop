package id.ac.ui.cs.advprog.eshop.utils;

import java.util.List;

import id.ac.ui.cs.advprog.eshop.product.model.Product;

public interface ProductService {
    List<Product> findAll();
    Product findById(String productId);
    Product create(Product product);
    Product update(Product product);
    boolean delete(Product product);
}
