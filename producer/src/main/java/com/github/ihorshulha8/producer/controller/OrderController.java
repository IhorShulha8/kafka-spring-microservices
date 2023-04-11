package com.github.ihorshulha8.producer.controller;

import com.github.ihorshulha8.producer.domain.Order;
import com.github.ihorshulha8.producer.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/order")
public class OrderController {
    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public String createOrder(@RequestBody Order order){
        log.info("create my order request received");
        return orderService.createOrder(order);
    }
}
