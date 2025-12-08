package com.example.E_Commerce.Backend.Project.dto;

// Used to create an order

import java.util.List;

public class OrderRequest {
    private Long userId;
    private List<OrderItemRequest> items;
}
