package com.example.circle;

import com.example.circle.rabbitmq.ps.ProducerPS;
import com.example.circle.rabbitmq.rout.ProducerRout;
import com.example.circle.rabbitmq.topic.ProducerTop;
import com.example.circle.rabbitmq.work.ProducerWork;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RabbitMQTests {
    @Autowired
    private ProducerWork product;

    @Autowired
    private ProducerPS producerPS;

    @Autowired
    private ProducerRout producerRout;

    @Autowired
    private ProducerTop producerTop;

    @Test
    public void test_top(){producerTop.send();}

    @Test
    public void test_rout(){producerRout.send();}

    @Test
    public void test_ps(){producerPS.send();}

    @Test
    public void test_Work(){
        product.send();
    }
}
