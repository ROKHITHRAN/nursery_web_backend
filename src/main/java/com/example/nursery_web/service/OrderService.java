package com.example.nursery_web.service;

import org.springframework.stereotype.Service;

import com.example.nursery_web.model.Orders;
import com.example.nursery_web.repository.OrderRepository;

import jakarta.transaction.Transactional;

@Service
public class OrderService {

    private final OrderRepository orderRepo;
    public OrderService(OrderRepository orderRepo)
    {
        this.orderRepo = orderRepo;
    }    

    public Orders addOrder(Orders order)
    {
        return orderRepo.save(order);
    }

    public void deleteOrder(Long orderId)
    {
        orderRepo.deleteById(orderId);
    }

    @Transactional
    public Orders updateOrder(Orders order)
    {
        Orders exist = orderRepo.findById(order.getOrderId())
                            .orElseThrow(()->new RuntimeException("Order not found"));

        // copy mutable fields from the incoming order to the managed entity
        // the user association is typically not modified here, but we allow it if
        // the caller passed a different user
        if (order.getUser() != null) {
            exist.setUser(order.getUser());
        }

        exist.setTotalPrice(order.getTotalPrice());
        exist.setTimeStamp(order.getTimeStamp());
        exist.setPaymentType(order.getPaymentType());
        exist.setStatus(order.getStatus());

        // if order items are supplied we replace the collection; CascadeType.ALL
        // and orphanRemoval=true on Orders.orderItems will take care of
        // persisting/deleting the children
        if (order.getOrderItems() != null) {
            exist.getOrderItems().clear();
            exist.getOrderItems().addAll(order.getOrderItems());
        }

        // because we are in a transaction and 'exist' is managed, changes
        // will be flushed automatically. we still return the updated instance
        // to the caller for convenience.
        return exist;
    }

    @Transactional
    public Orders setOrderStatus(Long orderId, String status)
    {
        Orders exist = orderRepo.findById(orderId)
                        .orElseThrow(()-> new RuntimeException("Order not found"));
        
        exist.setStatus(status);
        return exist;
    }

}
