package com.example.nursery_web.service;

import java.util.Optional;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.nursery_web.model.Users;
import com.example.nursery_web.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService 
{
    private final UserRepository userRepo;
    private final PasswordEncoder passwordEncoder;

    // Register User
    public Users register(Users user) {

        Optional<Users> existingUser = userRepo.findByEmail(user.getEmail());

        if (existingUser.isPresent()) {
            throw new RuntimeException("Email already registered");
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepo.save(user);
    }

    // Login
    public Users login(String email, String password) {

        Users user = userRepo.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Invalid Email"));

        if (!passwordEncoder.matches(password, user.getPassword())) {
            throw new RuntimeException("Invalid Password");
        }

        return user;
    }

}
