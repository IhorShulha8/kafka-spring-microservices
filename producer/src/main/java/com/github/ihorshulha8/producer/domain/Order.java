package com.github.ihorshulha8.producer.domain;

import lombok.Data;

@Data
public class Order {
    private String orderNumber;
    private String item;
    private Double amount;
}
