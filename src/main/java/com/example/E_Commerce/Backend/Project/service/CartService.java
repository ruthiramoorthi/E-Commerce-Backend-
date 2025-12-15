package com.example.E_Commerce.Backend.Project.service;

import com.example.E_Commerce.Backend.Project.dto.CartRequest;
import com.example.E_Commerce.Backend.Project.entity.Cart;

public interface CartService {
    String addToCart(CartRequest cartRequest);
    String removeItem(Long itemId);
    Cart viewCart();
}
