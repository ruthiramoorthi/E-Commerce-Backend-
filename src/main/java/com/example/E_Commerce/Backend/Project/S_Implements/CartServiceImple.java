package com.example.E_Commerce.Backend.Project.S_Implements;

import com.example.E_Commerce.Backend.Project.dto.CartRequest;
import com.example.E_Commerce.Backend.Project.entity.Cart;
import com.example.E_Commerce.Backend.Project.entity.Cart_Item;
import com.example.E_Commerce.Backend.Project.entity.Product;
import com.example.E_Commerce.Backend.Project.entity.User;
import com.example.E_Commerce.Backend.Project.repository.CartRepository;
import com.example.E_Commerce.Backend.Project.repository.Cart_ItemRepository;
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

    @Autowired
    Cart_ItemRepository cartItemRepository;

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

        Cart_Item existingItem = cart.getItems().stream()
                .filter(item -> item.getProduct().getId().equals(product.getId()))
                .findFirst()
                .orElse(null);

        if(existingItem != null){
            existingItem.setQuantity(existingItem.getQuantity()+ cartRequest.getQuantity());
            existingItem.setPrice(existingItem.getPrice() * product.getPrice());
            cartItemRepository.save(existingItem);
        } else{
            Cart_Item newItem = new Cart_Item();
            newItem.setCart(cart);
            newItem.setProduct(product);
            newItem.setQuantity(cartRequest.getQuantity());
            newItem.setPrice(product.getPrice() * cartRequest.getQuantity());
            cart.getItems().add(newItem);
            cartItemRepository.save(newItem);
        }

        reCalculateTotal(cart);
        cartRepository.save(cart);

        return "Product added to cart";
    }

    @Override
    public String removeItem(Long itemId) {
        Cart_Item cartItem = cartItemRepository.findById(itemId)
                .orElseThrow(()->new RuntimeException("cart item not found"));

        /*
        What is happening?
            You already have a CartItem
            And CartItem has this mapping:
        @ManyToOne
            private Cart cart;

        */
        Cart cart = cartItem.getCart();

        cart.getItems().remove(cartItem);
        cartItemRepository.delete(cartItem);

        reCalculateTotal(cart);
        cartRepository.save(cart);

        return "Item removed from cart";
    }

    @Override
    public Cart viewCart() {
        return getCart();
    }

    private void reCalculateTotal(Cart cart){
        double total = cart.getItems().stream()
                .mapToDouble(Cart_Item :: getPrice)
                .sum();
        cart.setTotal_amount(total);
    }

}
