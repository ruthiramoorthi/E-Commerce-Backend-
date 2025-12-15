package com.example.E_Commerce.Backend.Project.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class CartRequest {
    private Long productId;
    private int quantity;
}
