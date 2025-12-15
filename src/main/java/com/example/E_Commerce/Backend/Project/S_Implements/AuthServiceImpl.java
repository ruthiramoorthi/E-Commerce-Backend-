package com.example.E_Commerce.Backend.Project.S_Implements;

import com.example.E_Commerce.Backend.Project.dto.Auth.LoginRequest;
import com.example.E_Commerce.Backend.Project.dto.Auth.RegisterRequest;
import com.example.E_Commerce.Backend.Project.entity.Cart;
import com.example.E_Commerce.Backend.Project.entity.User;
import com.example.E_Commerce.Backend.Project.repository.CartRepository;
import com.example.E_Commerce.Backend.Project.repository.Cart_ItemRepository;
import com.example.E_Commerce.Backend.Project.repository.UserRepository;
import com.example.E_Commerce.Backend.Project.security.AuthResponse;
import com.example.E_Commerce.Backend.Project.security.JwtService;
import com.example.E_Commerce.Backend.Project.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthenticationService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    CartRepository cartRepository;

    @Autowired
    JwtService jwtService;

    @Override
    public AuthResponse register(RegisterRequest registerRequest) {
        User user = new User();
        user.setName(registerRequest.getName());
        user.setEmail(registerRequest.getEmail());
        user.setPassword(passwordEncoder.encode(registerRequest.getPassword()));

        userRepository.save(user);

        // create empty cart for user
        Cart cart = new Cart();
        cart.setUser(user);
        cartRepository.save(cart);

        String token = jwtService.generateToken(user.getEmail());

        return new AuthResponse(token);
    }

    @Override
    public AuthResponse login(LoginRequest loginRequest) {
        User user = userRepository.findByEmail(loginRequest.getEmail())
                .orElseThrow(() -> new RuntimeException("User Not Found"));

        if(!passwordEncoder.matches(loginRequest.getPassword(),user.getPassword())){
            throw new RuntimeException("Password Incorrect");
        }

        String token = jwtService.generateToken(user.getEmail());
        return new AuthResponse(token);
    }
}
