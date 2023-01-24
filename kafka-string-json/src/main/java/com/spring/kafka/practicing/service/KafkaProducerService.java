package com.spring.kafka.practicing.service;

import com.spring.kafka.practicing.entity.Message;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class KafkaProducerService {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    private KafkaTemplate<String, Message> kafkaTemplateMessageEntity;

    public ResponseEntity<String> publishString(String topic, String message){
        try{
            kafkaTemplate.send(topic, message);
            System.out.println("[KAFKA Producer is publishing] type: " + message.getClass() + "; message: " + message);
            return new ResponseEntity<>(message, HttpStatus.CREATED);
        }
        catch (Exception e){
            log.error(e.getMessage());
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<Message> publishMessage(String topic, Message message){
        try{
            kafkaTemplateMessageEntity.send(topic, message);
            System.out.println("[KAFKA Producer is publishing] type: " + message.getClass() + "; message: " + message.toString());
            return new ResponseEntity<>(message, HttpStatus.CREATED);
        }
        catch (Exception e){
            log.error(e.getMessage());
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
