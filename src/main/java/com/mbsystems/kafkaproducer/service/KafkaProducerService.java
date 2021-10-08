package com.mbsystems.kafkaproducer.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class KafkaProducerService {

    private final KafkaTemplate<String, String> kafkaTemplate;

    public KafkaProducerService(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(final String topic, final String key, final String value) {
        log.info(String.format("Producing Message - Key: %s, Value: %s to topic: %s", key, value, topic));

        kafkaTemplate.send(topic, key, value);
    }
}
