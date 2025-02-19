package id.ac.ui.cs.advprog.eshop.service;

import id.ac.ui.cs.advprog.eshop.model.Product;
import id.ac.ui.cs.advprog.eshop.repository.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ProductServiceImplTest {

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductServiceImpl productService;

    private Product sampleProduct;

    @BeforeEach
    void setUp() {
        sampleProduct = new Product();
        sampleProduct.setProductId("eb558e9f-1c39-460e-8860-71af6af63bd6");
        sampleProduct.setProductName("Sample Product");
        sampleProduct.setProductQuantity(100);
    }

    @Test
    void testCreateProduct() {
        when(productRepository.create(sampleProduct)).thenReturn(sampleProduct);

        Product created = productService.create(sampleProduct);

        assertNotNull(created);
        assertEquals(sampleProduct.getProductId(), created.getProductId());
        assertEquals(sampleProduct.getProductName(), created.getProductName());
        assertEquals(sampleProduct.getProductQuantity(), created.getProductQuantity());
        verify(productRepository, times(1)).create(sampleProduct);
    }

    @Test
    void testFindAllProducts() {
        List<Product> productList = new ArrayList<>();
        productList.add(sampleProduct);
        
        Product secondProduct = new Product();
        secondProduct.setProductId("abc-123");
        secondProduct.setProductName("Second Product");
        secondProduct.setProductQuantity(50);
        productList.add(secondProduct);

        when(productRepository.findAll()).thenReturn(productList.iterator());

        List<Product> result = productService.findAll();

        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals(sampleProduct.getProductId(), result.get(0).getProductId());
        assertEquals(secondProduct.getProductId(), result.get(1).getProductId());
        verify(productRepository, times(1)).findAll();
    }

    @Test
    void testFindAllWhenEmpty() {
        when(productRepository.findAll()).thenReturn(new ArrayList<Product>().iterator());

        List<Product> result = productService.findAll();

        assertNotNull(result);
        assertTrue(result.isEmpty());
        verify(productRepository, times(1)).findAll();
    }

    @Test
    void testFindByIdExistingProduct() {
        when(productRepository.findById(sampleProduct.getProductId())).thenReturn(sampleProduct);

        Product found = productService.findById(sampleProduct.getProductId());

        assertNotNull(found);
        assertEquals(sampleProduct.getProductId(), found.getProductId());
        verify(productRepository, times(1)).findById(sampleProduct.getProductId());
    }

    @Test
    void testFindByIdNonExistentProduct() {
        String nonExistentId = "non-existent-id";
        when(productRepository.findById(nonExistentId)).thenReturn(null);

        Product found = productService.findById(nonExistentId);

        assertNull(found);
        verify(productRepository, times(1)).findById(nonExistentId);
    }

    @Test
    void testDeleteExistingProduct() {
        when(productRepository.delete(sampleProduct)).thenReturn(true);

        boolean deleted = productService.delete(sampleProduct);

        assertTrue(deleted);
        verify(productRepository, times(1)).delete(sampleProduct);
    }

    @Test
    void testDeleteNonExistentProduct() {
        when(productRepository.delete(sampleProduct)).thenReturn(false);

        boolean deleted = productService.delete(sampleProduct);

        assertFalse(deleted);
        verify(productRepository, times(1)).delete(sampleProduct);
    }

    @Test
    void testEditExistingProduct() {
        Product updatedProduct = new Product();
        updatedProduct.setProductId(sampleProduct.getProductId());
        updatedProduct.setProductName("Updated Name");
        updatedProduct.setProductQuantity(200);

        when(productRepository.edit(updatedProduct)).thenReturn(updatedProduct);

        Product result = productService.edit(updatedProduct);

        assertNotNull(result);
        assertEquals(updatedProduct.getProductName(), result.getProductName());
        assertEquals(updatedProduct.getProductQuantity(), result.getProductQuantity());
        verify(productRepository, times(1)).edit(updatedProduct);
    }

    @Test
    void testEditNonExistentProduct() {
        when(productRepository.edit(sampleProduct)).thenReturn(null);

        Product result = productService.edit(sampleProduct);

        assertNull(result);
        verify(productRepository, times(1)).edit(sampleProduct);
    }
}