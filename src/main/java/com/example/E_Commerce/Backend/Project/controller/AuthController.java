package com.example.E_Commerce.Backend.Project.controller;

import com.example.E_Commerce.Backend.Project.dto.Auth.LoginRequest;
import com.example.E_Commerce.Backend.Project.dto.Auth.RegisterRequest;
import com.example.E_Commerce.Backend.Project.security.AuthResponse;
import com.example.E_Commerce.Backend.Project.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    AuthenticationService authenticationService;

    @PostMapping("/register")
    public AuthResponse register(@RequestBody RegisterRequest registerRequest){
       return authenticationService.register(registerRequest);
    }

    @PostMapping("/login")
    public AuthResponse login(@RequestBody LoginRequest loginRequest){
        return authenticationService.login(loginRequest);
    }
}
