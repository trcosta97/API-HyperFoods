package com.hyperFoods.api.entity.Food;

import com.hyperFoods.api.dto.food.CreateFoodDTO;
import com.hyperFoods.api.dto.food.UpdateFoodDTO;
import com.hyperFoods.api.entity.Restaurant;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "tab_food")
@Entity(name = "food")
public class Food {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "food_id")
    private long id;
    private String name;
    private String description;
    private BigDecimal price;
    @Enumerated(EnumType.STRING)
    @Column(name = "food_type")
    private FoodType type;
    @ManyToOne
    @JoinColumn(name = "restaurant_id", referencedColumnName = "restaurant_id")
    private Restaurant restaurant;
    @Column(name = "is_active", columnDefinition = "BIT(1) DEFAULT 1")
    private boolean active;
    @Column(name = "created")
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime created;

    public Food(CreateFoodDTO data) {
        this.name = data.name();
        this.description = data.description();
        this.price = data.price();
        this.type = data.type();
        this.active = true;
        this.created = LocalDateTime.now();
    }

    public Food(UpdateFoodDTO data) {
        this.name = data.name();
        this.description = data.description();
        this.price = data.price();
        this.type = data.type();
        this.active = true;
        this.created = LocalDateTime.now();
    }
}

