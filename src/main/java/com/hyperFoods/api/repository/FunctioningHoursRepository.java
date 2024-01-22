package com.hyperFoods.api.repository;

import com.hyperFoods.api.entity.restaurant.FunctioningHours;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FunctioningHoursRepository extends JpaRepository<FunctioningHours, Long> {
}
