package com.hyperFoods.api.dto.restaurant;

import jakarta.validation.constraints.NotBlank;

public record CreateRestaurantDTO(
        @NotBlank
        String name,
        @NotBlank
        String description

) {
}
