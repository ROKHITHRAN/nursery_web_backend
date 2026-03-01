package com.example.nursery_web.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.example.nursery_web.model.OrderItem;
import com.example.nursery_web.model.Orders;
import com.example.nursery_web.service.OrderService;

@RestController
@RequestMapping("/api/orders")
@CrossOrigin(origins = "http://localhost:3000")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public Orders addOrder(@RequestBody Orders order) {
        return orderService.addOrder(order);
    }

    @PutMapping
    public Orders updateOrder(@RequestBody Orders order) {
        return orderService.updateOrder(order);
    }


    @PatchMapping("/{id}/status")
    public Orders updateOrderStatus(@PathVariable Long id,
                                    @RequestParam String status) {
        return orderService.setOrderStatus(id, status);
    }

    @DeleteMapping("/{id}")
    public String deleteOrder(@PathVariable Long id) {
        orderService.deleteOrder(id);
        return "Order deleted successfully";
    }

    @GetMapping("/{id}/items")
    public List<OrderItem> getOrderItems(@PathVariable Long id) {
        return orderService.getOrderItems(id);
    }
}