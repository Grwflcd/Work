package com.example.circle.rabbitmq.ps;


import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "queueB")
public class Comsuer2 {
    @RabbitHandler
    public void process(String msg)throws Exception{
        System.out.println("Comsuer2：" + msg);
    }
}
