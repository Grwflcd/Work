package com.example.circle.rabbitmq.ps;


import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProducerPS {
    @Autowired
    private AmqpTemplate amqpTemplate;

    public void send() {

        try{
            while(true){
                //向fanoutExchange交换机发送消息，绑定的routing_key写任何字符都会被忽略（第二个参无效）
                amqpTemplate.convertAndSend("fanoutExchange", "", "this is a message");
                Thread.sleep(100);
            }
        }catch (Exception e){

        }
    }
}
