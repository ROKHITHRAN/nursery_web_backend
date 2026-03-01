package com.example.nursery_web.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.nursery_web.model.Users;
import com.example.nursery_web.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepo;

    // Register User
    public Users register(Users user) {

        Optional<Users> existingUser = userRepo.findByEmail(user.getEmail());

        if (existingUser.isPresent()) {
            throw new RuntimeException("Email already registered");
        }

        return userRepo.save(user);
    }

    // Login
    public Users login(String email, String password) {

        Users user = userRepo.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Invalid Email"));

        if (!user.getPassword().equals(password)) {
            throw new RuntimeException("Invalid Password");
        }

        return user;
    }

    // Get User Details
    public Users getUserById(Long id) {

        return userRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }
}