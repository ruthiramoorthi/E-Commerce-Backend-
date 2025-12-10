package com.example.E_Commerce.Backend.Project.service;

import com.example.E_Commerce.Backend.Project.dto.CategoryDto;

import java.util.List;

public interface CategoryService {
    CategoryDto createCategory(CategoryDto dto);
    List<CategoryDto> getAllCategory();
}
