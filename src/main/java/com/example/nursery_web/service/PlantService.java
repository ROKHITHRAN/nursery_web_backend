package com.example.nursery_web.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.nursery_web.model.Plant;
import com.example.nursery_web.repository.PlantRepository;

@Service
public class PlantService 
{
    private final PlantRepository plantRepo;
    public PlantService(PlantRepository plantRepo)
    {
        this.plantRepo = plantRepo;
    }


    public List<Plant> getPlantByCategory(Long catId)
    {
        return plantRepo.getPlantByCategory(catId);
    }

    public Plant getPlantById(Long plantId)
    {
        return plantRepo.getById(plantId);
    }

    public Plant addPlant(Plant plant)
    {
        return plantRepo.save(plant);
    }

    @Transactional
    public Plant updatePlant(Plant plant)
    {
        Plant exist = plantRepo.findById(plant.getPlantId())
                        .orElseThrow(()-> new RuntimeException("Plant not found"));
        exist.setPrice(plant.getPrice());
        exist.setPlantName(plant.getPlantName());
        exist.setDescription(plant.getDescription());
        exist.setCategory(plant.getCategory());
        exist.setAvailQuantity(plant.getAvailQuantity());
        return exist;
    }

    public void removePlant(Long plantId)
    {
        plantRepo.deleteById(plantId);
    }
}
