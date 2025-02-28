package id.ac.ui.cs.advprog.eshop.product.service;


import id.ac.ui.cs.advprog.eshop.product.model.Product;
import id.ac.ui.cs.advprog.eshop.product.repository.ProductRepository;
import id.ac.ui.cs.advprog.eshop.utils.DeleteService;
import id.ac.ui.cs.advprog.eshop.utils.GetService;
import id.ac.ui.cs.advprog.eshop.utils.PostService;
import id.ac.ui.cs.advprog.eshop.utils.UpdateService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class ProductServiceImpl implements GetService<Product>, PostService<Product>, UpdateService<Product>, DeleteService<Product> {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product create(Product product) {
        productRepository.create(product);
        return product;
    }

    @Override
    public List<Product> findAll() {
        Iterator<Product> productIterator = productRepository.findAll();
        List<Product> allProduct = new ArrayList<>();
        productIterator.forEachRemaining(allProduct::add);
        return allProduct;
    }

    @Override
    public Product findById(String productId) {
        return productRepository.findById(productId);
    }

    @Override
    public boolean delete(Product product) {
        return productRepository.delete(product);
    }

    @Override
    public Product update(Product product) {
        return productRepository.update(product);
    }
}
