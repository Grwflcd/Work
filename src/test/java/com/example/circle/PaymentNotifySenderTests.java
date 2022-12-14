package com.example.circle;

import com.example.circle.Entity.PaymentNotifySender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PaymentNotifySenderTests {
    @Autowired
    private PaymentNotifySender sender;

    @Test
    public void test_sender() {
        for(int i=0;i<10;i++) sender.sender("支付订单号："+System.currentTimeMillis());
    }
}

