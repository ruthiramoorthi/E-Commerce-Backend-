package com.example.E_Commerce.Backend.Project.controller;

import com.example.E_Commerce.Backend.Project.dto.CreateProductRequest;
import com.example.E_Commerce.Backend.Project.dto.ProductDto;
import com.example.E_Commerce.Backend.Project.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/products")

public class ProductController {

    @Autowired
    private ProductService productService;

    public ResponseEntity<ProductDto> createProduct(@RequestBody CreateProductRequest request){
        return ResponseEntity.ok(productService.createProduct(request));
    }
}
