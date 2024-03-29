package com.hyperFoods.api.service;

import com.hyperFoods.api.entity.Food.Food;
import com.hyperFoods.api.entity.restaurant.Restaurant;
import com.hyperFoods.api.entity.restaurant.FunctioningHours;
import com.hyperFoods.api.repository.FunctioningHoursRepository;
import com.hyperFoods.api.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantService {

    @Autowired
    private RestaurantRepository repository;

    @Autowired
    private FunctioningHoursRepository functioningHoursRepository;

    public Restaurant save(Restaurant restaurant) {
        return repository.save(restaurant);
    }

    public Restaurant findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Page findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public Restaurant update(Restaurant restaurant, Long id) {
        Restaurant existingRestaurant = repository.findById(id).orElse(null);
        if (restaurant.getName() != null){
            existingRestaurant.setName(restaurant.getName());
        }
        if (restaurant.getDescription() != null){
            existingRestaurant.setDescription(restaurant.getDescription());
        }
        if (restaurant.getAddress() != null){
            existingRestaurant.setAddress(restaurant.getAddress());
        }
        return repository.save(existingRestaurant);
    }

    public List<Food> addFood(Restaurant restaurant, Food food) {
        food.setRestaurant(restaurant);
        restaurant.addFood(food);
        var updatedRestaurant = repository.save(restaurant);
        return updatedRestaurant.getFoods();
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    public void deactivateById(Long id) {
        Restaurant restaurant = repository.findById(id).orElse(null);
        restaurant.setActive(false);
        repository.save(restaurant);
    }

    public Restaurant addFunctioningHours(Restaurant restaurant, FunctioningHours functioningHours) {
        restaurant.setFunctioningHours(functioningHours);
        return repository.save(restaurant);
    }
}
