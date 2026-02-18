package com.example.nursery_web.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;    

    private Long totalPrice;
    private String timeStamp;
    private String paymentType;

    @ManyToOne
    @JoinColumn(name = "userId")
    private Users user;

    // No-arg constructor (required by JPA since when It create object in order to 
    // push data taken from DB it will create like new Orders() and don't know abt our
    //parametrized constructor)
    public Orders() {
    }

    // Constructor with parameters
    public Orders(Long totalPrice, String timeStamp, String paymentType, Users user) {
        this.totalPrice = totalPrice;
        this.timeStamp = timeStamp;
        this.paymentType = paymentType;
        this.user = user;
    }

     public Long getOrderId() {
        return orderId;
    }

    public Long getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Long totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

}