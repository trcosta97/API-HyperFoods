package com.hyperFoods.api.service;

import com.hyperFoods.api.entity.Food.Food;
import com.hyperFoods.api.entity.ShoppingCart;
import com.hyperFoods.api.repository.ShoppingCartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShoppingCartService {

    @Autowired
    private ShoppingCartRepository repository;

    public ShoppingCart save(ShoppingCart shoppingCart) {
        return repository.save(shoppingCart);
    }

    public ShoppingCart findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Page findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public List<Food> addItem(ShoppingCart shoppingCart, Food food) {
        shoppingCart.addItem(food);
        var updatedShoppingCart = repository.save(shoppingCart);
        return updatedShoppingCart.getFood();
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    public void deactivateById(Long id) {
        ShoppingCart shoppingCart = repository.findById(id).orElse(null);
        shoppingCart.setActive(false);
        repository.save(shoppingCart);
    }

}
