package com.example.nursery_web.controller;

import org.springframework.web.bind.annotation.*;

import com.example.nursery_web.model.Users;
import com.example.nursery_web.service.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "http://localhost:3000")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    // 3️⃣ Get User Details
    @GetMapping("/{id}")
    public Users getUserDetails(@PathVariable Long id) {
        return userService.getUserById(id);
    }
}