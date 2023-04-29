package com.github.ihorshulha8.domain;

import lombok.Data;

@Data
public class FoodOrder {
    private String orderNumber;
    private String item;
    private Double amount;
}
