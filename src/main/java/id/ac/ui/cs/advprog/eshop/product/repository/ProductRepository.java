package id.ac.ui.cs.advprog.eshop.product.repository;


import org.springframework.stereotype.Repository;

import id.ac.ui.cs.advprog.eshop.product.model.Product;
import id.ac.ui.cs.advprog.eshop.utils.RepositoryInterface.BaseRepository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Repository
public class ProductRepository implements BaseRepository<Product> {
    private List<Product> productData = new ArrayList<>();
    
    public Iterator<Product> findAll() {
        return productData.iterator();
    }

    public Product findById(String productId) {
        if (productId == null) {
            return null;
        }
        return productData.stream()
                .filter(p -> productId.equals(p.getId()))
                .findFirst()
                .orElse(null);
    }

    public Product create(Product product) {
        productData.add(product);
        return product;
    }

    public Product update(Product product) {
        if (product == null) {
            return null;
        }

        Product existingProduct = findById(product.getId());
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
