package com.example.circle.Entity;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Date;

@Component
public class Sender {
    @Resource
    private AmqpTemplate rabbitTemplate;

    public void send(){
        String context = "hello" + new Date();
        System.out.println("Sender :"+context);
        this.rabbitTemplate.convertAndSend("hello",context);
    }
}
