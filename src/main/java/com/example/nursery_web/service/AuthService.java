package com.example.nursery_web.service;

import java.util.Optional;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.nursery_web.model.Users;
import com.example.nursery_web.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepo;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    public Users register(Users user) {

        if (userRepo.findByEmail(user.getEmail()).isPresent()) {
            throw new RuntimeException("Email already registered");
        }

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole("USER");

        return userRepo.save(user);
    }

    public String login(String email, String password) {

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(email, password)
        );

        Users user = userRepo.findByEmail(email)
                .orElseThrow();

        return jwtService.generateToken(user.getEmail(), user.getRole());
    }
}