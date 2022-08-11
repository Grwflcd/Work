package com.example.circle.rabbitmq.topic;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "queueB")
public class ComsuerTop2 {
    @RabbitHandler
    public void process(String msg)throws Exception{
        System.out.println("ComsuerTop-queueB：" + msg);
    }
}
