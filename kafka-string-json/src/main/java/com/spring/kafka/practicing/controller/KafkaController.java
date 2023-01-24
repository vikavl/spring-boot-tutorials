package com.spring.kafka.practicing.controller;

import com.spring.kafka.practicing.entity.Message;
import com.spring.kafka.practicing.service.KafkaProducerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@Slf4j
public class KafkaController {

    private final KafkaProducerService producerService;

    public KafkaController(KafkaProducerService producerService) {
        this.producerService = producerService;
    }

    @RequestMapping(value="/publish", method= RequestMethod.POST)
    public ResponseEntity<String> postString(
            @RequestParam(name = "topic") Optional<String> topic,
            @RequestParam(name = "message") String message
    ) {
        // if topic is not set, will define by default as "stringTopic"
        final String TOPIC = topic.orElse("stringTopic");
        return producerService.publishString(TOPIC, message);
    }

    @RequestMapping(value="/publishMessage", method= RequestMethod.POST)
    public ResponseEntity<Message> postMessage(
            @RequestParam(name = "topic") Optional<String> topic,
            @RequestBody Message message
    ) {
        // if topic is not set, will define by default as "messageTopic"
        final String TOPIC = topic.orElse("messageTopic");
        return producerService.publishMessage(TOPIC, message);
    }
}
