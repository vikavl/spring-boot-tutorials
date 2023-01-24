package com.spring.kafka.practicing.service;

import com.spring.kafka.practicing.entity.Message;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {

    @KafkaListener(
            topics = "stringTopic",
            groupId = "id",
            containerFactory = "kafkaListener")
    public void listenString(String message) {
        System.out.println("[KAFKA Consumer is listening] type: " + message.getClass() + "; message: " + message);
    }

    @KafkaListener(
            topics = "messageTopic",
            groupId = "id",
            containerFactory = "kafkaListenerMessageEntity")
    public void listenMessage(Message message) {
        System.out.println("[KAFKA Consumer is listening] type: " + message.getClass() + "; message: " + message.toString());
    }
}
