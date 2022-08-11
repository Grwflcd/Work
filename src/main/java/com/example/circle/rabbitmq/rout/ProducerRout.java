package com.example.circle.rabbitmq.rout;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProducerRout {
    @Autowired
    private AmqpTemplate amqpTemplate;

    public void send() {
        //向fanoutExchange交换机发送消息，绑定的routing_key写任何字符都会被忽略（第二个参无效）
        try{
            while(true){
                amqpTemplate.convertAndSend("directExchange","key123","this is a message rout");
                Thread.sleep(100);
            }
        }catch (Exception e){

        }

    }
}
