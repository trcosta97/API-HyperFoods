package com.hyperFoods.api.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "tab_address")
@Entity(name = "address")
public class Address {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "address_id")
    private long id;
    private String street;
    private String number;
    private String city;
    private String province;
    @Column(name = "zip_code")
    private String zipCode;
    @Column(name = "phone_number")
    private String phoneNumber;
    @Column(name = "active", columnDefinition = "BIT(1) DEFAULT 1")
    private boolean active;
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime created;
}
