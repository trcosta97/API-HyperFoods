package com.hyperFoods.api.service;

import com.hyperFoods.api.entity.Order;
import com.hyperFoods.api.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    private OrderRepository repository;

    public Order save(Order order) {
        return repository.save(order);
    }

    public Order findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    public void deactivateById(Long id) {
        Order existingOrder = repository.findById(id).orElse(null);
        existingOrder.setActive(false);
        repository.save(existingOrder);
    }


}
