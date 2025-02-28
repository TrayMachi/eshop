package id.ac.ui.cs.advprog.eshop.product.service;

import id.ac.ui.cs.advprog.eshop.product.model.Product;
import id.ac.ui.cs.advprog.eshop.utils.ServiceInterface.DeleteService;
import id.ac.ui.cs.advprog.eshop.utils.ServiceInterface.GetService;
import id.ac.ui.cs.advprog.eshop.utils.ServiceInterface.PostService;
import id.ac.ui.cs.advprog.eshop.utils.ServiceInterface.UpdateService;

public interface ProductService extends GetService<Product>, PostService<Product>, UpdateService<Product>, DeleteService<Product> {}
