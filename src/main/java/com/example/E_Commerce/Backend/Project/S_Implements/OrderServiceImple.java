package com.example.E_Commerce.Backend.Project.S_Implements;

import com.example.E_Commerce.Backend.Project.entity.*;
import com.example.E_Commerce.Backend.Project.enums.OrderStatus;
import com.example.E_Commerce.Backend.Project.repository.CartRepository;
import com.example.E_Commerce.Backend.Project.repository.OrderRepository;
import com.example.E_Commerce.Backend.Project.repository.UserRepository;
import com.example.E_Commerce.Backend.Project.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderServiceImple implements OrderService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private OrderRepository orderRepository;

    private User getLoggedInUser(){

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();

        return userRepository.findByEmail(email)
                .orElseThrow(()-> new RuntimeException("User Not Found"));
    }

    @Override
    public Order placeOrder() {

        User user = getLoggedInUser();
        Cart cart = cartRepository.findByUserId(user.getId())
                .orElseThrow(()->new RuntimeException("Cart Not Found"));

        if(cart.getItems().isEmpty()){
            throw new RuntimeException("Cart Is Empty");
        }

        Order order = new Order();
        order.setUser(user);
        order.setStatus(OrderStatus.PLACED);
        order.setOrderDate(LocalDateTime.now());

        List<Order_Item> orderItems = new ArrayList<>();
        double totalAmount = 0;

        for (Cart_Item cartItem : cart.getItems()){

            Order_Item orderItem = new Order_Item();
            orderItem.setOrder(order);
            orderItem.setProduct(cartItem.getProduct());
            orderItem.setQuantity(cartItem.getQuantity());
            orderItem.setAmount(cartItem.getProduct().getPrice());

            totalAmount += cartItem.getQuantity() * cartItem.getProduct().getPrice();
            orderItems.add(orderItem);
        }

        order.setItems(orderItems);
        order.setAmount(totalAmount);

        // CLEAR CART
        cart.getItems().clear();
        cartRepository.save(cart);

        return orderRepository.save(order);

    }

    @Override
    public List<Order> getUserOrders() {
        User user = getLoggedInUser();
        return orderRepository.findByUserId(user.getId());
    }

    @Override
    public Order getOrderById(Long orderId) {
        return orderRepository.findById(orderId)
                .orElseThrow(()-> new RuntimeException("Order Not Found"));
    }

    @Override
    public Order updateOrderStatus(Long orderId, String status) {
        Order order = getOrderById(orderId);
        order.setStatus(OrderStatus.valueOf(status));
        return orderRepository.save(order);
    }
}
