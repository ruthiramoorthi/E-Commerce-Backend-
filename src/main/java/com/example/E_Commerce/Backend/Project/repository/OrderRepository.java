package com.example.E_Commerce.Backend.Project.repository;

import com.example.E_Commerce.Backend.Project.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface OrderRepository extends JpaRepository<Order,Long> {

    List<Order> findByUserId(Long userId);

}
