package com.example.E_Commerce.Backend.Project.dto;

import java.util.List;

//Returned after placing an order.

public class OrderResponse {
    private Long orderId;
    private Long userId;
    private Double totalAmount;
    private String status;
    private List<OrderItemResponse> items;
}
