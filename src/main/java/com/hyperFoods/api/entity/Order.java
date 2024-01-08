package com.hyperFoods.api.entity;

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
@Table(name = "tab_order")
@Entity(name = "order")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private long id;
    @ManyToOne
    private User user;
    @OneToOne
    private ShoppingCart cart;
    private BigDecimal shipping;
    private BigDecimal price;
    @Column(name = "is_active", columnDefinition = "BIT(1) DEFAULT 1")
    private boolean active;
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime created;
}
