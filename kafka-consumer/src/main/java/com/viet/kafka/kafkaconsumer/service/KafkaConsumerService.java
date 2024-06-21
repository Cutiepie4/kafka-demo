package com.viet.kafka.kafkaconsumer.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {

    @KafkaListener(topics = "name-topic", groupId = "my-group")
    public void consume(String message) {
        System.out.println("Received message: " + message);
    }
}
