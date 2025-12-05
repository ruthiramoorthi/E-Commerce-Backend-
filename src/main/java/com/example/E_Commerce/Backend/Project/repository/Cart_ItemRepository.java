package com.example.E_Commerce.Backend.Project.repository;

import com.example.E_Commerce.Backend.Project.entity.Cart_Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Cart_ItemRepository extends JpaRepository<Cart_Item,Long> {
}
