package com.hyperFoods.api.dto;

import com.hyperFoods.api.entity.User;

public record UserListDTO(
        Long id,
        String name,
        String email
) {

    public UserListDTO(User user){
        this(user.getId(), user.getName(), user.getEmail());
    }
}
