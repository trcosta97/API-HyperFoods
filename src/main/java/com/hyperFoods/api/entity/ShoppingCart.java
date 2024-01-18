package com.hyperFoods.api.entity;


import com.hyperFoods.api.entity.Food.Food;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity(name = "shoppingCart")
@Table(name = "tab_shopping_cart")
public class ShoppingCart {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private long id;
    @ManyToOne
    private User user;
    @ManyToMany
    private List<Food> food;
    private BigDecimal price;
    private boolean active;


    public void addItem(Food food) {
        this.food.add(food);
        this.price = this.price.add(food.getPrice());
    }
}
