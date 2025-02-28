package id.ac.ui.cs.advprog.eshop.product.service;

import id.ac.ui.cs.advprog.eshop.product.model.Product;
import id.ac.ui.cs.advprog.eshop.utils.DeleteService;
import id.ac.ui.cs.advprog.eshop.utils.GetService;
import id.ac.ui.cs.advprog.eshop.utils.PostService;
import id.ac.ui.cs.advprog.eshop.utils.UpdateService;

public interface ProductService extends GetService<Product>, PostService<Product>, UpdateService<Product>, DeleteService<Product> {}
