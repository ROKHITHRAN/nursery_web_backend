package com.example.nursery_web.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    
    private String userName;
    private String password;
    private String mobileNo;
    private String email;

    @OneToMany(mappedBy = "user")
    private List<Orders> orders;

    // No-arg constructor (required by JPA)
    public Users() {
    }

    public Users(String userName, String password, String mobileNo, String email) {
        this.userName = userName;
        this.password = password;
        this.mobileNo = mobileNo;
        this.email = email;
    }

    public Long getId() {
        return userId;
    }
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getMobileNo() {
        return mobileNo;
    }
    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public List<Orders> getOrders() {
        return orders;
    }

    public void setOrders(List<Orders> orders) {
        this.orders = orders;
    }

}
