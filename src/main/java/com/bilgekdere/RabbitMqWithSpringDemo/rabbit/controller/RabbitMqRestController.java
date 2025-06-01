package com.bilgekdere.RabbitMqWithSpringDemo.rabbit.controller;

import com.bilgekdere.RabbitMqWithSpringDemo.rabbit.listener.RabbitMqListener;
import com.bilgekdere.RabbitMqWithSpringDemo.rabbit.publisher.RabbitMqPublisher;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RabbitMqRestController {
    private RabbitMqPublisher rabbitMqPublisher;
    private RabbitMqListener rabbitMqListener;

    RabbitMqRestController (RabbitMqPublisher rabbitMqPublisher, RabbitMqListener rabbitMqListener) {
        this.rabbitMqListener = rabbitMqListener;
        this.rabbitMqPublisher = rabbitMqPublisher;
    }

    @GetMapping(value = "/rabbit")
    public String textMessage() {
        rabbitMqPublisher.sendMessage("hello");
        rabbitMqListener.receiveMessage("hello listener");
        return "message sending";
    }
}
