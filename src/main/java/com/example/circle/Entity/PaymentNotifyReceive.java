package com.example.circle.Entity;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "notify.payment")
public class PaymentNotifyReceive {
    @RabbitHandler
    public void receive(String msg){
        System.out.println("notify.payment receive message: "+msg);
    }
}
