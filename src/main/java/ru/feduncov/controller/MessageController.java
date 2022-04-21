package ru.feduncov.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.feduncov.dto.MessageDTO;

@RestController
@RequestMapping("/send")
public class MessageController {

    @Value("${topic}")
    private String topic;

    private final KafkaTemplate<String, MessageDTO> kafkaTemplate;

    public MessageController(KafkaTemplate<String, MessageDTO> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @PostMapping
    public ResponseEntity<String> post(@RequestBody MessageDTO message) {
        kafkaTemplate.send(topic, message);
        return ResponseEntity.ok("Successful");
    }
}
