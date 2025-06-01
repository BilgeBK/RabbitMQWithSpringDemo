package com.bilgekdere.RabbitMqWithSpringDemo.rabbit;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMqConfig {

    @Bean
    public Queue queue() {
        return new Queue("queue", true,false,false);
    }

    @Bean
    public Exchange exchange() {
        return  new DirectExchange("directExchange");
    }

    @Bean
    public Binding binding(Queue queue, Exchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with("routingKey").noargs();
    }
    @Bean
    public CachingConnectionFactory connectionFactory() {
        CachingConnectionFactory connectionFactory = new CachingConnectionFactory("localhost");
        //connectionFactory.setPort(8080);
        return connectionFactory;
    }
}


