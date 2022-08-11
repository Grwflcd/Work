package com.example.circle.rabbitmq.work;

import com.example.circle.rabbitmq.model.Product;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class ProducerWork {
    @Resource
    AmqpTemplate amqpTemplate;
    public void send(){
        for(int i=0;i<10;i++)amqpTemplate.convertAndSend("springboot-queue",new Product(111l,"欧莱雅"));
    }

}

