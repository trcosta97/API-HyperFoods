package com.hyperFoods.api.dto.restaurant;

import com.hyperFoods.api.dto.address.CreateAddressDTO;
import jakarta.validation.constraints.NotBlank;

public record CreateRestaurantDTO(
        @NotBlank
        String name,
        @NotBlank
        String description,

        CreateAddressDTO address


) {
}
