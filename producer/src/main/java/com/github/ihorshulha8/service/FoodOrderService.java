package com.github.ihorshulha8.service;

import com.github.ihorshulha8.domain.FoodOrder;
import com.github.ihorshulha8.service.producer.Producer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class FoodOrderService {

    private final Producer producer;
    private int count = 0;

    public FoodOrderService(Producer producer) {
        this.producer = producer;
    }

    public synchronized String createOrder(FoodOrder foodOrder) {
        if (foodOrder.getOrderNumber() == null || foodOrder.getOrderNumber().isBlank()) {
            foodOrder.setOrderNumber(String.valueOf(count));
            count++;
        }

        return producer.sendMessage(foodOrder);
    }
}
