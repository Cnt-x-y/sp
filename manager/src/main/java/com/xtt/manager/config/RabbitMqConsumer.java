package com.xtt.manager.config;

import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * @Author xuett
 * @Date 2019/6/6 15:43
 */
@Component
@Slf4j
public class RabbitMqConsumer {

    /**
     * 监听未申明队列
     *
     * @param message
     * @param channel
     */
    @RabbitListener(queues = RabbitMqConstant.UNROUTE_QUEUE_NAME)
    public void listenUnRouteQueue(Message message, Channel channel) {
        try {
            String receivedMessage = new String(message.getBody());
            System.out.println("接受到未申明队列消息：" + receivedMessage);
            channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
        } catch (Exception e) {
            log.info("接收到消息之后的处理发生异常:{}", e.getMessage());
        }
    }

}
