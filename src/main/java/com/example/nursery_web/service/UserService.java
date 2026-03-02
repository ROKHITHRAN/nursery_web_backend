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
    // Get User Details
    public Users getUserById(Long id) {

        return userRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }
}