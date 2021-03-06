package com.done.app;

import lombok.extern.log4j.Log4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Done Lin on 2017/5/13.
 */
@Log4j
public class Consumer {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("config/spring.xml");
        RabbitTemplate rabbitTemplate = (RabbitTemplate) context.getBean("rabbitTemplate");
       log.info("收到消息: " + rabbitTemplate.receiveAndConvert("spring.queue").toString());
    }
}
