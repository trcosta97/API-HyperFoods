package com.hyperFoods.api.dto.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record UpdateUserDTO(

        String name,
        @Email
        String email,
        String password

) {
}
