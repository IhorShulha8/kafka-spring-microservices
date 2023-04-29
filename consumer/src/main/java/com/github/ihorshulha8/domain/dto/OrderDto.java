package com.github.ihorshulha8.domain.dto;

import lombok.Data;
import lombok.Value;

@Data
@Value
public class OrderDto {
    String orderNumber;
    String item;
    String amount;
}
