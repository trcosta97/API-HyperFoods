package com.hyperFoods.api.service;

import com.hyperFoods.api.entity.Food.Food;
import com.hyperFoods.api.repository.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class FoodService {

    @Autowired
    private FoodRepository repository;

    public Food save(Food food) {
        return repository.save(food);
    }

    public Food findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Page findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public Food update(Food food) {
        Food existingFood = repository.findById(food.getId()).orElse(null);
        if (food.getName() != null){
            existingFood.setName(food.getName());
        }
        if (food.getDescription() != null){
            existingFood.setDescription(food.getDescription());
        }
        if (food.getPrice() != null){
            existingFood.setPrice(food.getPrice());
        }
        if (food.getType() != null){
            existingFood.setType(food.getType());
        }
        if (food.getRestaurant() != null){
            existingFood.setRestaurant(food.getRestaurant());
        }
        return repository.save(existingFood);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    public void deactivateById(Long id) {
        Food existingFood = repository.findById(id).orElse(null);
        existingFood.setActive(false);
        repository.save(existingFood);
    }

}
