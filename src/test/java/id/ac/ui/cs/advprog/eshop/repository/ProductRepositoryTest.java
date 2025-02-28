package id.ac.ui.cs.advprog.eshop.repository;

import id.ac.ui.cs.advprog.eshop.product.model.Product;
import id.ac.ui.cs.advprog.eshop.product.repository.ProductRepository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.InjectMocks;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ProductRepositoryTest {
    @InjectMocks
    ProductRepository productRepository;

    private Product sampleProduct;

    @BeforeEach
    void setUp() {
        sampleProduct = new Product();
        sampleProduct.setProductId("eb558e9f-1c39-460e-8860-71af6af63bd6");
        sampleProduct.setProductName("Sample Product");
        sampleProduct.setProductQuantity(100);
    }

    @Test
    void testCreateAndFind() {
        productRepository.create(sampleProduct);

        Iterator<Product> products = productRepository.findAll();
        assertTrue(products.hasNext());

        Product savedProduct = products.next();

        assertEquals(sampleProduct.getProductId(), savedProduct.getProductId());
        assertEquals(sampleProduct.getProductName(), savedProduct.getProductName());
        assertEquals(sampleProduct.getProductQuantity(), savedProduct.getProductQuantity());
    }

    @Test
    void testFindAllIfEmpty() {
        Iterator<Product> products = productRepository.findAll();
        assertFalse(products.hasNext());
    }

    @Test
    void testFindAllIfMoreThanOneProduct() {
        productRepository.create(sampleProduct);

        Product product2 = new Product();
        product2.setProductId("123e4567-e89b-12d3-a456-556642440001");
        product2.setProductName("Product 2");
        product2.setProductQuantity(200);
        productRepository.create(product2);

        Iterator<Product> products = productRepository.findAll();
        assertTrue(products.hasNext());

        Product savedProduct = products.next();
        assertEquals(sampleProduct.getProductId(), savedProduct.getProductId());

        savedProduct = products.next();
        assertEquals(product2.getProductId(), savedProduct.getProductId());

        assertFalse(products.hasNext());
    }

    @Test
    void testEditandFind() {
        Product product = new Product();
        product.setProductId("123e4567-e89b-12d3-a456-556642440000");
        product.setProductName("Product 1");
        product.setProductQuantity(100);
        productRepository.create(product);

        product.setProductName("Product 2");
        product.setProductQuantity(200);
        productRepository.update(product);

        Iterator<Product> products = productRepository.findAll();
        assertTrue(products.hasNext());

        Product savedProduct = products.next();

        assertEquals(product.getProductId(), savedProduct.getProductId());
        assertEquals(product.getProductName(), savedProduct.getProductName());
        assertEquals(product.getProductQuantity(), savedProduct.getProductQuantity());
    }

    @Test
    void testEditIfMoreThanOneProduct() {
        Product product1 = new Product();
        product1.setProductId("123e4567-e89b-12d3-a456-556642440000");
        product1.setProductName("Product 1");
        product1.setProductQuantity(100);
        productRepository.create(product1);

        Product product2 = new Product();
        product2.setProductId("123e4567-e89b-12d3-a456-556642440001");
        product2.setProductName("Product 2");
        product2.setProductQuantity(200);
        productRepository.create(product2);

        product1.setProductName("Product 3");
        product1.setProductQuantity(300);
        productRepository.update(product1);

        Iterator<Product> products = productRepository.findAll();
        assertTrue(products.hasNext());

        Product savedProduct = products.next();
        assertEquals(product1.getProductId(), savedProduct.getProductId());

        savedProduct = products.next();
        assertEquals(product2.getProductId(), savedProduct.getProductId());

        assertFalse(products.hasNext());
    }

    @Test
    void testEditIfEmpty() {
        Product product = new Product();
        product.setProductId("123e4567-e89b-12d3-a456-556642440000");
        product.setProductName("Product 1");
        product.setProductQuantity(100);
        Product result = productRepository.update(product);

        assertNull(result);
    }

    @Test
    void testEditNull() {
        Product product = null;

        Product savedProduct = productRepository.update(product);
        assertNull(savedProduct);
    }

    @Test
    void testDelete() {
        Product product = new Product();
        product.setProductId("123e4567-e89b-12d3-a456-556642440000");
        product.setProductName("Product 1");
        product.setProductQuantity(100);
        productRepository.create(product);

        productRepository.delete(product);

        Iterator<Product> products = productRepository.findAll();
        assertFalse(products.hasNext());
    }

    @Test
    void testDeleteIfMoreThanOneProduct() {
        Product product1 = new Product();
        product1.setProductId("123e4567-e89b-12d3-a456-556642440000");
        product1.setProductName("Product 1");
        product1.setProductQuantity(100);
        productRepository.create(product1);

        Product product2 = new Product();
        product2.setProductId("123e4567-e89b-12d3-a456-556642440001");
        product2.setProductName("Product 2");
        product2.setProductQuantity(200);
        productRepository.create(product2);

        productRepository.delete(product1);

        Iterator<Product> products = productRepository.findAll();
        assertTrue(products.hasNext());

        Product savedProduct = products.next();
        assertEquals(product2.getProductId(), savedProduct.getProductId());

        assertFalse(products.hasNext());
    }

    @Test
    void testFindById() {
        Product product = new Product();
        product.setProductId("123e4567-e89b-12d3-a456-556642440000");
        product.setProductName("Product 1");
        product.setProductQuantity(100);
        productRepository.create(product);

        Product savedProduct = productRepository.findById("123e4567-e89b-12d3-a456-556642440000");

        assertEquals(product, savedProduct);
    }

    @Test
    void testFindByIdNull() {
        Product savedProduct = productRepository.findById(null);
        assertNull(savedProduct);
    }
}