package com.example.nursery_web.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Plant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long plantId;

    
    private String plantName;
    private Long price;
    private Long availQuantity;
    private String description;
    
    @ManyToOne
    @JoinColumn(name = "cat_id")
    private Category category;
    
    public Plant(String plantName, Long price, Long availQuantity, String description, Category category) {
        this.plantName = plantName;
        this.price = price;
        this.availQuantity = availQuantity;
        this.description = description;
        this.category = category;
    }

    public Long getPlantId() {
        return plantId;
    }
    
    public String getPlantName() {
        return plantName;
    }

    public void setPlantName(String plantName) {
        this.plantName = plantName;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Long getAvailQuantity() {
        return availQuantity;
    }

    public void setAvailQuantity(Long availQuantity) {
        this.availQuantity = availQuantity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
