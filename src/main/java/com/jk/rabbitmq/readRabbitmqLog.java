package com.jk.rabbitmq;

import com.jk.AopDemo.AopDemo;
import com.jk.controller.AddRabbitMqLog;
import com.jk.model.Log;
import com.jk.util.ThreadPool;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2018/4/27 0027.
 */

@Component
public class readRabbitmqLog{

    @Autowired
    private MongoTemplate mongoTemplate;

    @RabbitHandler
    @RabbitListener(queues = "shop_Log_tf1")
    public void insertMongodb(Log log){
        /**
         * 单线程
         */
//        Thread InsertMongodbLog = new Thread(new InsertMongodbLog(mongoTemplate,log));
//        InsertMongodbLog.start();

        /**
         * 可缓存线程池
         */
        ThreadPool.executeCachedThreadPool(new InsertMongodbLog(mongoTemplate,log));
    }
}
