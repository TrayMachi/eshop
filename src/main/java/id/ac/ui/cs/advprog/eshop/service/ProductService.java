package id.ac.ui.cs.advprog.eshop.service;

import id.ac.ui.cs.advprog.eshop.model.Product;
import java.util.List;

public interface ProductService {
    List<Product> findAll();
    Product findById(String productId);
    Product create(Product product);
    Product edit(Product product);
    boolean delete(Product product);
}
