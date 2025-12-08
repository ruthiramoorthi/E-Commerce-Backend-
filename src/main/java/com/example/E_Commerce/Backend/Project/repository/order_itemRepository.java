package com.example.E_Commerce.Backend.Project.repository;

import com.example.E_Commerce.Backend.Project.entity.Order_Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface order_itemRepository extends JpaRepository<Order_Item,Long> {



}
