package com.example.circle.rabbitmq.work;


import com.example.circle.rabbitmq.model.Product;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "springboot-queue")
public class Comsuerw1 {
    @RabbitHandler
    public void consu(Product product){
        System.out.println("Consuerw1 message: "+product);
    }
}
