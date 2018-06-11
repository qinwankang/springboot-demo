package com.jk.controller;

import com.jk.AopDemo.AopDemo;
import com.jk.model.Log;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2018/4/27 0027.
 */
@Component
public class AddRabbitMqLog implements Runnable{

    private AmqpTemplate amqpTemplate;
    private Log log;


    @Override
    public void run() {
        amqpTemplate.convertAndSend("shop_Log_tf1",log);
    }

    public AddRabbitMqLog(AmqpTemplate amqpTemplate, Log log) {
        this.amqpTemplate = amqpTemplate;
        this.log = log;
    }

    public AddRabbitMqLog() {
    }
}

