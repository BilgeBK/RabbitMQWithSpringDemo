package com.bilgekdere.RabbitMqWithSpringDemo.rabbit.listener;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class RabbitMqListener {

    @RabbitListener(queues = "queue")
    public void receiveMessage(String message) {
        System.out.println("Receive Message: " + message);
    }
}
