package com.example.nursery_web.model;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;

@Entity
public class OrderItem {

    @EmbeddedId
    private OrderItemId orderItemId;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("orderId")
    @JoinColumn(name = "order_id")
    private Orders order;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("plantId")
    @JoinColumn(name = "plant_id")
    private Plant plant;

    private Long quantity;

    public OrderItem(Orders order, Plant plant, Long quantity) {
        this.order = order;
        this.plant = plant;
        this.quantity = quantity;
    }

     public Orders getOrder() {
        return order;
    }

    public void setOrder(Orders order) {
        this.order = order;
    }

    public Plant getPlant() {
        return plant;
    }

    public void setPlant(Plant plant) {
        this.plant = plant;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public OrderItemId getOrderItemId() {
        return orderItemId;
    }
}
