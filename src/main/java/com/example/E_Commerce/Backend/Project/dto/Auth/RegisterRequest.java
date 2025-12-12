package com.example.E_Commerce.Backend.Project.dto.Auth;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class RegisterRequest {
        private String name;
        private String email;
        private String password;
    }

