package com.jk.controller;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.UUID;

/**
 * Created by Administrator on 2018/4/27 0027.
 */
@Controller
@RequestMapping("rabbitmq")
public class AddRabbitMqNum {
    @Autowired
    private AmqpTemplate amqpTemplate;

    @RequestMapping("/testRabbitMq")
    public void testRabbitMq(){
        for (int i = 0; i < 10000; i++) {
            amqpTemplate.convertAndSend("shop_Log_tf", "第"+i+"个UUID:"+UUID.randomUUID().toString());
        }
    }
}
