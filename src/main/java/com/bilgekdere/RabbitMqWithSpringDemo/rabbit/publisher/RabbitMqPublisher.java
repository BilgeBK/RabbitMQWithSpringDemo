package com.bilgekdere.RabbitMqWithSpringDemo.rabbit.publisher;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
public class RabbitMqPublisher {
    private RabbitTemplate rabbitTemplate;

    public RabbitMqPublisher(RabbitTemplate rabbitTemplate) {
        this. rabbitTemplate = rabbitTemplate;
    }

    public void sendMessage(Object object) {
        rabbitTemplate.convertAndSend("directExchange","routing-key",object);
    }
}


