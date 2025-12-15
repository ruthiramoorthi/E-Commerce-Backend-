package com.example.E_Commerce.Backend.Project.controller;


import com.example.E_Commerce.Backend.Project.dto.CartRequest;
import com.example.E_Commerce.Backend.Project.entity.Cart;
import com.example.E_Commerce.Backend.Project.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CartController {
    @Autowired
    private CartService cartService;

    @PostMapping("/add")
    public String addToCart(@RequestBody CartRequest request) {
        return cartService.addToCart(request);
    }

    @DeleteMapping("/remove/{itemId}")
    public String removeItem(@PathVariable Long itemId) {
        return cartService.removeItem(itemId);
    }

    @GetMapping("/")
    public Cart viewCart() {
        return cartService.viewCart();
    }
}
