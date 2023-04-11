package com.github.ihorshulha8.producer.service.producer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.ihorshulha8.producer.domain.Order;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class Producer {

    @Value("${topic.name1}")
    private String topicName;

    private final ObjectMapper objectMapper;
    private final KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    public Producer(ObjectMapper objectMapper, KafkaTemplate<String, String> kafkaTemplate) {
        this.objectMapper = objectMapper;
        this.kafkaTemplate = kafkaTemplate;
    }

    @SneakyThrows
    public String sendMessage(Order order) {
        String orderAsMessage = objectMapper.writeValueAsString(order);
        kafkaTemplate.send(topicName, orderAsMessage);
        log.info("my order produced {}", orderAsMessage);
        return "message sent";
    }
}
