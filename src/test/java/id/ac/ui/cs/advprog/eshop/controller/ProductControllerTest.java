package id.ac.ui.cs.advprog.eshop.controller;

import id.ac.ui.cs.advprog.eshop.product.controller.ProductController;
import id.ac.ui.cs.advprog.eshop.product.model.Product;
import id.ac.ui.cs.advprog.eshop.utils.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class ProductControllerTest {

    @Mock
    private ProductService productService;

    @Mock
    private Model model;

    @InjectMocks
    private ProductController productController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCreateProductPage() {
        String viewName = productController.createProductPage(model);
        assertEquals("CreateProduct", viewName);
        verify(model, times(1)).addAttribute(eq("product"), any(Product.class));
    }

    @Test
    void testCreateProduct() {
        Product product = new Product();
        String viewName = productController.createProduct(product, model);
        assertEquals("redirect:/product/list", viewName);
        verify(productService, times(1)).create(product);
    }

    @Test
    void testProductListPage() {
        List<Product> products = Arrays.asList(new Product(), new Product());
        when(productService.findAll()).thenReturn(products);

        String viewName = productController.productListPage(model);
        assertEquals("ProductList", viewName);
        verify(model, times(1)).addAttribute("products", products);
    }

    @Test
    void testEditProductPage() {
        Product product = new Product();
        when(productService.findById("1")).thenReturn(product);

        String viewName = productController.editProductPage("1", model);
        assertEquals("EditProduct", viewName);
        verify(model, times(1)).addAttribute("product", product);
    }

    @Test
    void testEditProduct() {
        Product product = new Product();
        String viewName = productController.editProduct("1", product, model);
        assertEquals("redirect:/product/list", viewName);
        verify(productService, times(1)).update(product);
    }

    @Test
    void testDeleteProduct() {
        Product product = new Product();
        when(productService.findById("1")).thenReturn(product);

        String viewName = productController.deleteProduct("1", model);
        assertEquals("redirect:/product/list", viewName);
        verify(productService, times(1)).delete(product);
    }
}
