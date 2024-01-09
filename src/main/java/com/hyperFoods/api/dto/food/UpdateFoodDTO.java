package com.hyperFoods.api.dto.food;

import com.hyperFoods.api.entity.Food.FoodType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record UpdateFoodDTO(
        String name,
        String description,
        BigDecimal price,
        FoodType type
        
        
) {
}
