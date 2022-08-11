package com.example.circle.rabbitmq.topic;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProducerTop {
    @Autowired
    private AmqpTemplate amqpTemplate;

    public void send(){
        //向fanoutExchange交换机发送消息，绑定的routing_key写任何字符都会被忽略（第二个参无效）
        amqpTemplate.convertAndSend("topicExchange", "key.my", "this is a message top");
    }
}
