package com.example.E_Commerce.Backend.Project.service;

import com.example.E_Commerce.Backend.Project.dto.CreateProductRequest;
import com.example.E_Commerce.Backend.Project.dto.ProductDto;

import java.util.List;

public interface ProductService {
    ProductDto createProduct(CreateProductRequest request);
    ProductDto getProductById(Long id);
    List<ProductDto> getAllProducts();
    ProductDto updateProduct(Long id,CreateProductRequest request);
    void deleteProduct(Long id);
}
