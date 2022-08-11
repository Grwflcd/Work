package com.example.circle.rabbitmq.simple;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Send {

    @Autowired
    RabbitTemplate rabbitTemplate;

    public void send() {
        rabbitTemplate.convertAndSend("queue", "hello springboot and rabbit");
    }
}
