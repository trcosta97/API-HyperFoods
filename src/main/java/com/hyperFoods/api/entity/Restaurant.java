package com.hyperFoods.api.entity;

import com.hyperFoods.api.dto.restaurant.CreateRestaurantDTO;
import com.hyperFoods.api.entity.Food.Food;
import com.hyperFoods.api.entity.restaurant.FunctioningHours;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "tab_restaurant")
@Entity(name = "restaurant")
public class Restaurant {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "restaurant_id")
    private long id;
    private String name;
    private String description;
    @Column(name = "is_active", columnDefinition = "BIT(1) DEFAULT 1")
    private boolean active;
    @ElementCollection
    @JoinColumn
    @Column(name = "functioning_hour")
    private FunctioningHours functioningHours;
    @OneToOne
    @JoinColumn(name = "address_id", referencedColumnName = "address_id")
    private Address address;
    @OneToMany(mappedBy = "restaurant")
    private List<Food> foods;
    @Column(name = "created")
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime created;

    public Restaurant(CreateRestaurantDTO data) {
        this.name = data.name();
        this.description = data.description();
        this.active = true;
        this.created = LocalDateTime.now();
    }

    public void addFood(Food food) {
        foods.add(food);
    }
}
