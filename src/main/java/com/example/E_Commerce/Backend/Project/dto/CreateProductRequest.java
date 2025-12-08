package com.example.E_Commerce.Backend.Project.dto;

import lombok.Data;

// Used to receive new product details from admin.
@Data
public class CreateProductRequest {
    private String name;
    private String description;
    private Double price;
    private String imageUrl;
    private Long categoryId;
}
