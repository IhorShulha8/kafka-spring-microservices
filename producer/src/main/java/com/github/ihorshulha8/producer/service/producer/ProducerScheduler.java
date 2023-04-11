package com.github.ihorshulha8.producer.service.producer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ProducerScheduler {

    @Value("${topic.name2}")
    private String topicName;

    private final KafkaTemplate<String, String> kafkaTemplate;
    private Integer count = 0;

    @Autowired
    public ProducerScheduler(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Scheduled(fixedDelay = 1000)
    public void sendMessage(){
        count++;
        kafkaTemplate.send(topicName, "message " + count);
        log.info("sent message count {}", count);
    }
}
