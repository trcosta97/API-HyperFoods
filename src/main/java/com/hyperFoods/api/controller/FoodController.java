package com.hyperFoods.api.controller;

import com.hyperFoods.api.dto.food.UpdateFoodDTO;
import com.hyperFoods.api.entity.Food.Food;
import com.hyperFoods.api.service.FoodService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/food")
public class FoodController {

    @Autowired
    private FoodService service;

    @PutMapping
    public ResponseEntity update(@RequestBody @Valid UpdateFoodDTO data) {
        return ResponseEntity.ok(service.update(new Food(data)));
    }
}
