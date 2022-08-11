package com.example.circle.rabbitmq.simple;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "queue")
public class Recv {

    @RabbitHandler
    public void consume(String message){
        System.out.println("message:"+message);
    }
}
