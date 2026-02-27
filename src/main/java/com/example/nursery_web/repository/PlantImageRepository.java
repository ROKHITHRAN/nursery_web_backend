package com.example.nursery_web.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.nursery_web.model.PlantImage;

public interface PlantImageRepository extends JpaRepository<PlantImage,Long> 
{
    @Query("select i from PlantImage i where i.plant.plantId = :plantId")
    public List<PlantImage> getPlantImages(@Param("plantId") Long plantId);
}
