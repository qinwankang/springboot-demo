package com.jk.rabbitmq;

import com.jk.model.Log;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2018/4/27 0027.
 */
@Component
@RabbitListener(queues = "shop_Log_tf")
public class ReadRabbitmqNum {
    @RabbitHandler
    public void process(String info){
        System.out.println("从队列中获取的信息："+info);
    }
}


