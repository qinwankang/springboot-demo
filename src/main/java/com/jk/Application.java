package com.jk;

import org.springframework.amqp.core.Queue;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * Created by yangzhichao on 2018-04-19.
 */
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public Queue makeQueue(){
        return new Queue("shop_Log_tf");
    }

    @Bean
    public Queue makeQueue1(){
        return new Queue("shop_Log_tf1");
    }
}
