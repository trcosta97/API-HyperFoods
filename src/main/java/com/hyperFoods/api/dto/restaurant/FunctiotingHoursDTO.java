package com.hyperFoods.api.dto.restaurant;

import com.hyperFoods.api.entity.restaurant.FunctioningHours;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.util.List;

public record FunctiotingHoursDTO (
        List<DayOfWeek> days,
        LocalDateTime openingTime,
        LocalDateTime closingTime
)
{





}
