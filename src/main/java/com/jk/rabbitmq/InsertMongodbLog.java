package com.jk.rabbitmq;

import com.jk.model.Log;
import com.mongodb.Mongo;
import org.springframework.data.mongodb.core.MongoTemplate;

/**
 * Created by Administrator on 2018/4/28 0028.
 */
public class InsertMongodbLog implements Runnable{

    private MongoTemplate mongoTemplate;
    private Log log;
    @Override
    public void run() {
        mongoTemplate.insert(log);
    }

    public InsertMongodbLog(MongoTemplate mongoTemplate, Log log) {
        this.mongoTemplate = mongoTemplate;
        this.log = log;
    }

    public InsertMongodbLog() {
    }
}
