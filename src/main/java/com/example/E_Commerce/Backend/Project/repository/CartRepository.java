package com.example.E_Commerce.Backend.Project.repository;

import com.example.E_Commerce.Backend.Project.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CartRepository extends JpaRepository<Cart,Long> {

    Optional<Cart> findByUserId(Long userId);

}
