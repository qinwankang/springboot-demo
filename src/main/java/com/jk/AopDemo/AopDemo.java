package com.jk.AopDemo;

import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.LinkedList;
import java.util.UUID;

import com.jk.controller.AddRabbitMqLog;
import com.jk.model.Log;
import com.jk.rabbitmq.readRabbitmqLog;
import com.jk.util.ThreadPool;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.aop.AfterReturningAdvice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Aspect
@Component
public class AopDemo{

	@Autowired
	private AmqpTemplate amqpTemplate;

	@Autowired
	private MongoTemplate mongoTemplate;

	//匹配com.zkn.learnspringboot.web.controller包及其子包下的所有类的所有方法
	@Pointcut("execution(* com.jk.controller..*.*(..))")
	public void webLog(){
	}

	@Before("webLog()")
	public void deBefore(JoinPoint joinPoint) throws Throwable {
		Log log = new Log();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		// 接收到请求，记录请求内容
		ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		HttpServletRequest request = attributes.getRequest();
		// 记录下请求内容
//		System.out.println("URL : " + request.getRequestURL().toString());
//		System.out.println("HTTP_METHOD : " + request.getMethod());
//		System.out.println("IP : " + request.getRemoteAddr());
//		System.out.println("CLASS_METHOD : " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
//		System.out.println("ARGS : " + Arrays.toString(joinPoint.getArgs()));

		log.setUrl(request.getRequestURL().toString());
		log.setHttpmethod(request.getMethod());
		log.setIp(request.getRemoteAddr());
		log.setClassmethod(joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
		log.setArgs(Arrays.toString(joinPoint.getArgs()));
		log.setActtime(sdf.format(new Date()));
		/**
		 * 单线程
		 */
//		Thread addLogthread = new Thread(new AddRabbitMqLog(amqpTemplate,log));
//		addLogthread.start();

		/**
		 * 可缓存线程池
		 */
		ThreadPool.executeCachedThreadPool(new AddRabbitMqLog(amqpTemplate,log));
	}

}
