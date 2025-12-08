package com.example.E_Commerce.Backend.Project.repository;

import com.example.E_Commerce.Backend.Project.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface CategoryRepository extends JpaRepository<Category,Long> {

}
