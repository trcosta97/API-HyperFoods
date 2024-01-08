package com.hyperFoods.api.repository;

import com.hyperFoods.api.entity.ShoppingCart;
import com.hyperFoods.api.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, Long> {

    Page<ShoppingCart> findAll(Pageable pageable);

}
