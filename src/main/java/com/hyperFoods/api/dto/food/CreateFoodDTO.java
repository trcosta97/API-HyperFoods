package com.hyperFoods.api.dto.food;

import com.hyperFoods.api.entity.Food.FoodType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record CreateFoodDTO(
        @NotBlank
        String name,
        @NotBlank
        String description,
        @NotNull
        BigDecimal price,
        @NotBlank
        FoodType type
        
        
) {
}
