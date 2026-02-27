package com.example.nursery_web.service;

import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.nursery_web.repository.OrderRepository;
import com.example.nursery_web.model.OrderItem;
import com.example.nursery_web.model.Orders;
import com.example.nursery_web.model.Plant;
import com.example.nursery_web.model.Users;
import com.example.nursery_web.repository.OrderItemRepository;
import com.example.nursery_web.repository.PlantRepository;
import com.example.nursery_web.repository.UserRepository;

import lombok.RequiredArgsConstructor;


@Service
@Transactional
@RequiredArgsConstructor
public class CartService {

    private final OrderRepository orderRepo;
    private final OrderItemRepository orderItemRepo;
    private final PlantRepository plantRepo;
    private final UserRepository userRepo;

    public void addToCart(Long userId, Long plantId, Long quantity) {

        Users user = userRepo.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Orders cart = orderRepo.getCartByUser(userId, "CART")
                .orElseGet(() -> {
                    Orders newCart = new Orders();
                    newCart.setUser(user);
                    newCart.setStatus("CART");
                    return orderRepo.save(newCart);
                });

        Plant plant = plantRepo.findById(plantId)
                .orElseThrow(() -> new RuntimeException("Plant not found"));

        Optional<OrderItem> existingItem =
                orderItemRepo.findByOrderAndPlant(cart, plant);

        if (existingItem.isPresent()) {

            OrderItem item = existingItem.get();
            item.setQuantity(item.getQuantity() + quantity);

        } else {

            OrderItem newItem = new OrderItem(cart, plant, quantity);
            orderItemRepo.save(newItem);
        }
    }

    @Transactional
    public void decreaseQuantity(Long userId, Long plantId, Long quantity) {

        Orders cart = orderRepo.getCartByUser(userId, "CART")
                        .orElseThrow(()-> new RuntimeException("Cart not found"));
        Plant plant = plantRepo.findById(plantId)
                .orElseThrow(() -> new RuntimeException("Plant not found"));

        OrderItem item = orderItemRepo.findByOrderAndPlant(cart, plant)
                .orElseThrow(() -> new RuntimeException("Item not in cart"));

        Long newQty = item.getQuantity() - quantity;

        if (newQty <= 0) {
            orderItemRepo.delete(item);
        } else {
            item.setQuantity(newQty);
        }
    }

}