package com.example.E_Commerce.Backend.Project.S_Implements;

import com.example.E_Commerce.Backend.Project.dto.CartRequest;
import com.example.E_Commerce.Backend.Project.entity.Cart;
import com.example.E_Commerce.Backend.Project.entity.Product;
import com.example.E_Commerce.Backend.Project.entity.User;
import com.example.E_Commerce.Backend.Project.repository.CartRepository;
import com.example.E_Commerce.Backend.Project.repository.ProductRepository;
import com.example.E_Commerce.Backend.Project.repository.UserRepository;
import com.example.E_Commerce.Backend.Project.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class CartServiceImple implements CartService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    CartRepository cartRepository;

    @Autowired
    ProductRepository productRepository;

    // Helper : Get logged-in User
    private User getCurrentUser(){
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User Not Found"));
    }

    public Cart getCart(){
        User user = getCurrentUser();
        return cartRepository.findByUserId(user.getId())
                .orElseThrow(() ->new RuntimeException("Cart not Found"));
    }

    @Override
    public String addToCart(CartRequest cartRequest) {

        Cart cart = getCart();

        Product product = productRepository.findById(cartRequest.getProductId())
                .orElseThrow(()->new RuntimeException("Product Not Found"));


    }

    @Override
    public String removeItem(Long itemId) {
        return "";
    }

    @Override
    public Cart viewCart() {
        return null;
    }

}
