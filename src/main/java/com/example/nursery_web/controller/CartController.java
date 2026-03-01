package com.example.nursery_web.controller;

import org.springframework.web.bind.annotation.*;

import com.example.nursery_web.service.CartService;

@RestController
@RequestMapping("/api/cart")
@CrossOrigin(origins = "http://localhost:3000")
public class CartController {

    private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @PostMapping("/add")
    public String addItemToCart(@RequestParam Long userId,
                                @RequestParam Long plantId,
                                @RequestParam Long quantity) {

        cartService.addToCart(userId, plantId, quantity);
        return "Item added to cart successfully";
    }

    @PatchMapping("/decrease")
    public String decreaseQuantity(@RequestParam Long userId,
                                   @RequestParam Long plantId,
                                   @RequestParam Long quantity) {

        cartService.decreaseQuantity(userId, plantId, quantity);
        return "Cart quantity updated successfully";
    }
}
