package com.example.circle.rabbitmq.rout;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "queueA")
public class ComsuerRout {
    @RabbitHandler
    public void process(String msg) throws Exception {
        System.out.println("queueA：" + msg);
    }
}
