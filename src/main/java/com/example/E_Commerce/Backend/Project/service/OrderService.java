package com.example.E_Commerce.Backend.Project.service;

import com.example.E_Commerce.Backend.Project.entity.Order;

import java.util.List;

public interface OrderService {

    Order placeOrder();

    List<Order> getUserOrders();

    Order getOrderById(Long orderId);

    Order updateOrderStatus(Long orderId,String status);
}
