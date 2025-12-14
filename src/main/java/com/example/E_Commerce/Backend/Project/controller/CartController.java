package com.example.E_Commerce.Backend.Project.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

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
