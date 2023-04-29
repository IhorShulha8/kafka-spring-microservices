package com.github.ihorshulha8.controller;

import com.github.ihorshulha8.domain.FoodOrder;
import com.github.ihorshulha8.service.FoodOrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/orders")
public class FoodOrderController {
    private final FoodOrderService foodOrderService;

    @Autowired
    public FoodOrderController(FoodOrderService foodOrderService) {
        this.foodOrderService = foodOrderService;
    }

    @PostMapping
    public String createOrder(@RequestBody FoodOrder foodOrder){
        log.info("create my order request received");
        return foodOrderService.createOrder(foodOrder);
    }
}
