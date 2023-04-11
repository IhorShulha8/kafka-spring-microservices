package com.github.ihorshulha8.consumer.service.consumer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.ihorshulha8.consumer.domain.Order;
import com.github.ihorshulha8.consumer.domain.dto.OrderDto;
import com.github.ihorshulha8.consumer.service.OrderService;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class Consumer {

    private static final String TOPIC_NAME = "${topic.name1}";

    private final ObjectMapper objectMapper;
    private final ModelMapper modelMapper;
    private final OrderService orderService;

    @Autowired
    public Consumer(ObjectMapper objectMapper, ModelMapper modelMapper, OrderService orderService) {
        this.objectMapper = objectMapper;
        this.modelMapper = modelMapper;
        this.orderService = orderService;
    }

    @SneakyThrows
    @KafkaListener(topics = TOPIC_NAME)
    public void consumerOrders(String message) {
        log.info("order consumed {}", message);
        OrderDto orderDto = objectMapper.readValue(message, OrderDto.class);
        Order order = modelMapper.map(orderDto, Order.class);

        orderService.persistOrder(order);
    }
}
