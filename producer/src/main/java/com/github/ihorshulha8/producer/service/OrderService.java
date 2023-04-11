package com.github.ihorshulha8.producer.service;

import com.github.ihorshulha8.producer.domain.Order;
import com.github.ihorshulha8.producer.service.producer.Producer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class OrderService {

    private final Producer producer;
    private int count = 0;

    public OrderService(Producer producer) {
        this.producer = producer;
    }

    public synchronized String createOrder(Order order) {
        if (order.getOrderNumber() == null || order.getOrderNumber().isBlank()) {
            order.setOrderNumber(String.valueOf(count));
            count++;
        }

        return producer.sendMessage(order);
    }
}
