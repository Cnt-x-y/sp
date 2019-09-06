package com.xtt.manager.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

/**
 * RabbitMq配置类
 *
 * @Author xuett
 * @Date 2019/6/6 14:31
 */
@Configuration
public class RabbitMqConfig {

  /*  @Autowired
    private RabbitTemplate rabbitTemplate;

    *//**
     * 增强{@link RabbitTemplate}
     *//*
    @PostConstruct
    public void initRabbitTemplate() {
        rabbitTemplate.setMessageConverter(messageConverter());
        rabbitTemplate.setMandatory(true);
        rabbitTemplate.setReturnCallback(new RabbitMqReturnCallBack());
        rabbitTemplate.setConfirmCallback(new RabbitMqConfirmCallBack());
    }*/

    //------------------------------队列申明----------------------------//

    /**
     * 订单队列,TTL = 1分钟，60000
     *
     * @return
     */
    @Bean
    public Queue orderQueue() {
        Map<String, Object> arguments = new HashMap<String, Object>(3);
        arguments.put("x-message-ttl", 60000);
        arguments.put("x-dead-letter-exchange", RabbitMqConstant.DLX_ONE_MINUTES_EXCHANGE_NAME);
        arguments.put("x-dead-letter-routing-key", RabbitMqConstant.DLX_ONE_MINUTES_ROUTINGKEY_NAME);
        return new Queue(RabbitMqConstant.ORDER_QUEUE_NAME, true, false, false, arguments);
    }

    /**
     * 没有路由的，进入此队列
     *
     * @return
     */
    @Bean
    public Queue unRouteQueue() {
        return QueueBuilder.durable(RabbitMqConstant.UNROUTE_QUEUE_NAME).build();
    }

    /**
     * 一分钟死信队列
     *
     * @return
     */
    @Bean
    public Queue dlxOneMinutesQueue() {
        return QueueBuilder.durable(RabbitMqConstant.DLX_ONE_MINUTES_QUEUE_NAME).build();
    }

    /**
     * 三十分钟死信队列
     *
     * @return
     */
    @Bean
    public Queue dlxThirtyMinutesQueue() {
        return QueueBuilder.durable(RabbitMqConstant.DLX_THIRTY_MINUTES_QUEUE_NAME).build();
    }

    /**
     * 2小时死信队列
     *
     * @return
     */
    @Bean
    public Queue dlxTwoHoursQueue() {
        return QueueBuilder.durable(RabbitMqConstant.DLX_TWO_HOURS_QUEUE_NAME).build();
    }

    //------------------------------交换器申明----------------------------//

    @Bean
    public Exchange orderExchange() {
        Map<String, Object> arguments = new HashMap<>(4);
        // 当发往exchange-rabbit-springboot-advance的消息,routingKey和bindingKey没有匹配上时，将会由exchange-unroute交换器进行处理
        arguments.put("alternate-exchange", RabbitMqConstant.UNROUTE_EXCHANGE_NAME);
        return new DirectExchange(RabbitMqConstant.ORDER_EXCHANGE_NAME, true, false, arguments);
    }

    @Bean
    public FanoutExchange unRouteExchange() {
        return new FanoutExchange(RabbitMqConstant.UNROUTE_EXCHANGE_NAME);
    }

    @Bean
    public FanoutExchange dlxOneMinutesExchange() {
        return new FanoutExchange(RabbitMqConstant.DLX_ONE_MINUTES_EXCHANGE_NAME);
    }

    @Bean
    public FanoutExchange dlxThirtyMinutesExchange() {
        return new FanoutExchange(RabbitMqConstant.DLX_THIRTY_MINUTES_EXCHANGE_NAME);
    }

    @Bean
    public FanoutExchange dlxTwoHoursExchange() {
        return new FanoutExchange(RabbitMqConstant.DLX_TWO_HOURS_EXCHANGE_NAME);
    }

    //------------------------------绑定申明----------------------------//

    @Bean
    public Binding orderBinding() {
        return BindingBuilder.bind(orderQueue()).to(orderExchange()).with(RabbitMqConstant.ORDER_ROUTINGKEY_NAME).noargs();
    }

    @Bean
    public Binding unRouteBinding() {
        return BindingBuilder.bind(unRouteQueue()).to(unRouteExchange());
    }

    @Bean
    public Binding dlxOneMinutesBinding() {
        return BindingBuilder.bind(dlxOneMinutesQueue()).to(dlxOneMinutesExchange());
    }

    @Bean
    public Binding dlxThirtyMinutesBinding() {
        return BindingBuilder.bind(dlxThirtyMinutesQueue()).to(dlxThirtyMinutesExchange());
    }

    @Bean
    public Binding dlxTwoHoursBinding() {
        return BindingBuilder.bind(dlxTwoHoursQueue()).to(dlxTwoHoursExchange());
    }

    @Slf4j
    private static class RabbitMqConfirmCallBack implements RabbitTemplate.ConfirmCallback {
        @Override
        public void confirm(CorrelationData correlationData, boolean ack, String cause) {
            if (ack) {
                log.info("生产者确认消息,id:{}", correlationData.getId());
            } else {
                log.info("消息可能未到达rabbitmq服务器,id:{}", correlationData.getId());
            }
        }
    }

    @Slf4j
    private static class RabbitMqReturnCallBack implements RabbitTemplate.ReturnCallback {
        @Override
        public void returnedMessage(Message message, int replyCode, String replyText, String exchange, String routingKey) {
            log.info("replyCode:[{}]", replyCode);
        }
    }

    @Bean
    public MessageConverter messageConverter() {
        Jackson2JsonMessageConverter jackson2JsonMessageConverter = new Jackson2JsonMessageConverter();
        return new Jackson2JsonMessageConverter();
    }
}
