package com.example.nursery_web.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.example.nursery_web.model.PlantImage;
import com.example.nursery_web.service.PlantImageService;

@RestController
@RequestMapping("/api/plant-images")
@CrossOrigin(origins = "http://localhost:3000")
public class PlantImageController {

    private final PlantImageService plantImageService;

    public PlantImageController(PlantImageService plantImageService) {
        this.plantImageService = plantImageService;
    }

    @GetMapping("/plant/{plantId}")
    public List<PlantImage> getPlantImages(@PathVariable Long plantId) {
        return plantImageService.getPlantImages(plantId);
    }

    @PostMapping
    public PlantImage addPlantImage(@RequestBody PlantImage plantImage) {
        return plantImageService.addPlantImage(plantImage);
    }

    
    @DeleteMapping("/{id}")
    public String deletePlantImage(@PathVariable Long id) {
        plantImageService.deletePlantImage(id);
        return "Plant image deleted successfully";
    }

    @PatchMapping
    public PlantImage updatePlantImage(@RequestBody PlantImage plantImage)
    {
        return plantImageService.updatePlantImage(plantImage);
    }
}