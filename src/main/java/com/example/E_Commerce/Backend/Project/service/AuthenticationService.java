package com.example.E_Commerce.Backend.Project.service;

import com.example.E_Commerce.Backend.Project.dto.Auth.LoginRequest;
import com.example.E_Commerce.Backend.Project.dto.Auth.RegisterRequest;
import com.example.E_Commerce.Backend.Project.security.AuthResponse;

public interface AuthenticationService {
    AuthResponse register(RegisterRequest registerRequest);
    AuthResponse login(LoginRequest loginRequest);
}
