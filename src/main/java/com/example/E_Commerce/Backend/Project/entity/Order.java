package com.example.E_Commerce.Backend.Project.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "orders")

public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User user;

    private double amount;


    private String status; //PENDING,SHIPPED,DELIVERED

    @OneToMany(mappedBy = "order",cascade = CascadeType.ALL)
    private List<Order_Item> items;

    private LocalDateTime orderDate;
}
