package com.kafka.example.kafka;

import com.kafka.example.repository.MessageRepository;
import com.kafka.example.model.Message;
import io.micronaut.configuration.kafka.annotation.KafkaListener;
import io.micronaut.configuration.kafka.annotation.Topic;

import jakarta.inject.Inject;
import java.time.LocalDateTime;

@KafkaListener
public class MessageListener {

    @Inject
    private MessageRepository messageRepository;

    @Topic("my-topic")
    public void receive(String messagePayload) {
        Message message = new Message();
        message.setPayload(messagePayload);
        message.setReceivedAt(LocalDateTime.now());

        messageRepository.save(message);
        System.out.println("Saved message: " + messagePayload);
    }
}
