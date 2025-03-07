package id.ac.ui.cs.advprog.eshop.order.service;


import java.util.List;

import id.ac.ui.cs.advprog.eshop.order.model.Order;

public interface OrderService {
    public Order createOrder(Order order);
    public Order updateStatus(String orderId, String status);
    public Order findById(String orderId);
    public List<Order> findAllByAuthor(String author);
}