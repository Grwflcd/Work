package com.example.circle.rabbitmq.topic;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "queueA")
public class ComsuerTop {
    @RabbitHandler
    public void process(String msg)throws Exception{
        System.out.println("ComsuerTop-queueA：" + msg);
    }
}
