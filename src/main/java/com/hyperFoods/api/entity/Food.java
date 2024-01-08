package com.hyperFoods.api.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

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
}

