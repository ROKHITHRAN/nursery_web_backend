package com.example.nursery_web.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.nursery_web.model.PlantImage;
import com.example.nursery_web.repository.PlantImageRepository;

@Service
public class PlantImageService {
    
    private final PlantImageRepository plantImageRepo;
    public PlantImageService(PlantImageRepository plantImageRepo)
    {
        this.plantImageRepo = plantImageRepo;
    }
    
    public List<PlantImage> getPlantImages(Long plantId)
    {
        return plantImageRepo.getPlantImages(plantId);
    }

    public PlantImage addPlantImage(PlantImage plantImage)
    {
        return plantImageRepo.save(plantImage);
    }

    public void deletePlantImage(Long plantImageId)
    {
        plantImageRepo.deleteById(plantImageId);
    }

}
