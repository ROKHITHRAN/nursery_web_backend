package com.example.nursery_web.model;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Embeddable;

@Embeddable
public class OrderItemId implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long orderId;
    private Long plantId;

    public OrderItemId() {}

    public OrderItemId(Long orderId, Long plantId) {
        this.orderId = orderId;
        this.plantId = plantId;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getPlantId() {
        return plantId;
    }

    public void setPlantId(Long plantId) {
        this.plantId = plantId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderItemId that = (OrderItemId) o;
        return Objects.equals(orderId, that.orderId) && Objects.equals(plantId, that.plantId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId, plantId);
    }

    @Override
    public String toString() {
        return "OrderItemId{" +
                "orderId=" + orderId +
                ", plantId=" + plantId +
                '}';
    }
}