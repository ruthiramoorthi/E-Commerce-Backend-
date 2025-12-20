package com.example.E_Commerce.Backend.Project.controller;

import com.example.E_Commerce.Backend.Project.entity.Order;
import com.example.E_Commerce.Backend.Project.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/orders")
@RequiredArgsConstructor

public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/place")
    public Order placeOrder(){
        return orderService.placeOrder();
    }

    @GetMapping
    public List<Order> getUserOrders(){
        return orderService.getUserOrders();
    }

    @GetMapping("/{id}")
    public Order getOrder(@PathVariable Long id){
        return orderService.getOrderById(id);
    }

    @PutMapping("/{id}/status")
    public Order updateStatus(
            @PathVariable Long id,
            @RequestParam String status
    ){
        return orderService.updateOrderStatus(id, status);
    }
}
