package com.example.nursery_web.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.nursery_web.model.Orders;

@Repository
public interface OrderRepository extends JpaRepository<Orders,Long> {

    @Query("select o from Orders o where o.user.userId=:userId and o.status=:status")
    public Optional<Orders> getCartByUser(@Param("userId") Long userId, @Param("status") String status);
}
