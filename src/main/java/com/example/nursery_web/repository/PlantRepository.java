package com.example.nursery_web.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.nursery_web.model.Plant;

@Repository
public interface PlantRepository extends JpaRepository<Plant,Long>
{
    @Query("select p from Plant p where p.category.catId = :catId")
    public List<Plant> getPlantByCategory(@Param("catId") Long catId);
}
