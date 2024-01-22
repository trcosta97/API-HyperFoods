package com.hyperFoods.api.entity.restaurant;


import com.hyperFoods.api.dto.restaurant.FunctiotingHoursDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "tab_functioning_hours")
@Entity(name = "functioning_hours")
public class FunctioningHours {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "functioning_hours_id")
    private long id;
    private LocalDateTime openingTime;
    private LocalDateTime closingTime;
    private LocalDateTime lastUpdated;
    @OneToOne
    @JoinColumn(name = "restaurant_id", referencedColumnName = "restaurant_id")
    private Restaurant restaurant;

    public FunctioningHours(FunctiotingHoursDTO data) {
        this.openingTime = data.openingTime();
        this.closingTime = data.closingTime();
        this.lastUpdated = LocalDateTime.now();
    }
}
