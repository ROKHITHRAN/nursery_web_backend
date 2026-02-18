package com.example.nursery_web.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long catId;

    private String catName;
    private String catImageUrl;

    @OneToMany(mappedBy = "category")
    List<Plant> plants;

    public Category(){
        
    }
    
    public Category(String catName, String catImageUrl, List<Plant> plants) {
        this.catName = catName;
        this.catImageUrl = catImageUrl;
        this.plants = plants;
    }
    

    public Long getCatId() {
        return catId;
    }

    public String getCatName() {
        return catName;
    }

    public void setCatName(String catName) {
        this.catName = catName;
    }

    public String getCatImageUrl() {
        return catImageUrl;
    }

    public void setCatImageUrl(String catImageUrl) {
        this.catImageUrl = catImageUrl;
    }

    public List<Plant> getPlants() {
        return plants;
    }

    public void setPlants(List<Plant> plants) {
        this.plants = plants;
    }
}
