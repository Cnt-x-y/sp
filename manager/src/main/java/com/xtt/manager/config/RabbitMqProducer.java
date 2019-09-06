package com.xtt.manager.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * RabbitMq生产者
 *
 * @Author xuett
 * @Date 2019/6/6 14:36
 */
@Component
@Slf4j
public class RabbitMqProducer {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void send(String exchange, String routingKey, Object message) {
        rabbitTemplate.convertAndSend(exchange, routingKey, message, new CorrelationData(UUID.randomUUID().toString()));
        log.info("发送一条消息,exchange:{},routingKey:{},message:{}", exchange, routingKey, message);
    }

    public void send(String exchange, String routingKey, Object message, CorrelationData correlationData) {
        rabbitTemplate.convertAndSend(exchange, routingKey, message, correlationData);
        log.info("发送一条消息,exchange:{},routingKey:{},message:{}", exchange, routingKey, message);
    }
}
