package com.github.ihorshulha8.service;

import com.github.ihorshulha8.domain.Order;
import com.github.ihorshulha8.repository.OrderRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class OrderService {

    private final OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public void persistOrder(Order order) {
        log.info("my order before persisted {}", order);
        Order persistedOrder = orderRepository.save(order);
        log.info("my order after persisted {}", persistedOrder);
    }
}
