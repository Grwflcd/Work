package com.example.circle.rabbitmq.ps;


import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "queueC")
public class Comsuer3 {

    @RabbitHandler
    public void process(String msg) throws Exception {
        System.out.println("Comsuer3：" + msg);
    }
}
