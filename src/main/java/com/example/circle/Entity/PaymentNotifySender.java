package com.example.circle.Entity;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class PaymentNotifySender {
    @Resource
    private AmqpTemplate rabbitTemplate;

    public void sender(String msg){
        System.out.println("notify.payment send message: "+msg);
        rabbitTemplate.convertAndSend("notify.payment", msg);
    }
}
