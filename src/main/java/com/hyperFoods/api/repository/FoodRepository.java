package com.hyperFoods.api.repository;

import com.hyperFoods.api.entity.Food;
import com.hyperFoods.api.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodRepository extends JpaRepository<Food, Long> {

    Page<Food> findAll(Pageable pageable);

}
