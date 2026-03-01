package com.example.nursery_web.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.nursery_web.model.OrderItem;
import com.example.nursery_web.model.OrderItemId;
import com.example.nursery_web.model.Orders;
import com.example.nursery_web.model.Plant;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem,OrderItemId>{
    
    @Query("select o from OrderItem o where o.order = :order and o.plant = :plant")
    public Optional<OrderItem> findByOrderAndPlant(@Param("order") Orders order, @Param("plant") Plant plant);

    @Query("select oi from OrderItem oi where oi.order.orderId = :orderId")
    List<OrderItem> findByOrderId(@Param("orderId") Long orderId);
}
