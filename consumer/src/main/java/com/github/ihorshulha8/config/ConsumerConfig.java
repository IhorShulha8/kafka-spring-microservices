package com.github.ihorshulha8.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.TopicBuilder;

@EnableKafka
@Configuration
public class ConsumerConfig {

    @Value("${topic.name}")
    private String topicName;

    @Bean
    public NewTopic topic(){
        return TopicBuilder
                .name(topicName)
                .partitions(1)
                .replicas(1)
                .build();
    }

    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }
}
