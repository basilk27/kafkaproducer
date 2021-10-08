package com.mbsystems.kafkaproducer.controllers;

import com.mbsystems.kafkaproducer.model.IncomingMessage;
import com.mbsystems.kafkaproducer.service.KafkaProducerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
public class KafkaProducerController {

    private final KafkaProducerService kafkaProducerService;

    public KafkaProducerController(KafkaProducerService kafkaProducerService) {
        this.kafkaProducerService = kafkaProducerService;
    }

    @PostMapping("/post")
    public String sendMessageToKafka(@RequestBody IncomingMessage message) {
        kafkaProducerService.sendMessage(message.getKey(), message.getKey(), message.getValue());

        return String
                .format("Success - Message of key %s is sent to Kafka Topic: %s", message.getKey(), message.getKey());
    }
}
