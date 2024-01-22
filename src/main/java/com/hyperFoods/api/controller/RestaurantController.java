package com.hyperFoods.api.controller;

import com.hyperFoods.api.dto.food.CreateFoodDTO;
import com.hyperFoods.api.dto.restaurant.CreateRestaurantDTO;
import com.hyperFoods.api.dto.restaurant.FunctiotingHoursDTO;
import com.hyperFoods.api.entity.Food.Food;
import com.hyperFoods.api.entity.restaurant.Restaurant;
import com.hyperFoods.api.entity.restaurant.FunctioningHours;
import com.hyperFoods.api.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/restaurant")
public class RestaurantController {

    @Autowired
    private RestaurantService service;

    @PostMapping
    public ResponseEntity create(@RequestBody CreateRestaurantDTO data, UriComponentsBuilder uriBuilder) {
        var restaurant = service.save(new Restaurant(data));
        var uri = uriBuilder.path("/restaurant/{id}").buildAndExpand(restaurant.getId()).toUri();
        return ResponseEntity.created(uri).body(restaurant);
    }

    @PutMapping("/{id}/hours")
    public ResponseEntity addFunctioningHours(@PathVariable long id,@RequestBody FunctiotingHoursDTO data){
        var restaurant = service.findById(id);
        var functioningHours = new FunctioningHours(data);

        return ResponseEntity.ok(service.addFunctioningHours(restaurant, functioningHours));
    }

    @PutMapping("/{id}/food")
    public ResponseEntity addFood(@PathVariable long id, @RequestBody CreateFoodDTO data){
        var restaurant = service.findById(id);
        var food = new Food(data);
        return ResponseEntity.ok(service.addFood(restaurant, food));
    }
}
