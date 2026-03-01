package com.example.nursery_web.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.example.nursery_web.model.Plant;
import com.example.nursery_web.service.PlantService;

@RestController
@RequestMapping("/api/plants")
@CrossOrigin(origins = "http://localhost:3000")
public class PlantController {

    private final PlantService plantService;

    public PlantController(PlantService plantService) {
        this.plantService = plantService;
    }


    @GetMapping("/{id}")
    public Plant getPlantById(@PathVariable Long id) {
        return plantService.getPlantById(id);
    }

    @GetMapping("/category/{catId}")
    public List<Plant> getPlantsByCategory(@PathVariable Long catId) {
        return plantService.getPlantByCategory(catId);
    }

    @PostMapping
    public Plant addPlant(@RequestBody Plant plant) {
        return plantService.addPlant(plant);
    }

   
    @PutMapping
    public Plant updatePlant(@RequestBody Plant plant) {
        return plantService.updatePlant(plant);
    }

    @DeleteMapping("/{id}")
    public String removePlant(@PathVariable Long id) {
        plantService.removePlant(id);
        return "Plant removed successfully";
    }
}