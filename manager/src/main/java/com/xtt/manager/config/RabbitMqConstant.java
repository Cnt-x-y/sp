package com.xtt.manager.config;

/**
 * RabbitMq常量定义
 *
 * @Author xuett
 * @Date 2019/6/6 16:33
 */
public class RabbitMqConstant {

    /**
     * 订单相关的队列，交换器，路由
     */
    public static final String ORDER_QUEUE_NAME = "order_queue";
    public static final String ORDER_EXCHANGE_NAME = "order_exchange";
    public static final String ORDER_ROUTINGKEY_NAME = "order_routingkey";

    /**
     * 未申明路由的信息的队列，交换器,不需要路由
     */
    public static final String UNROUTE_QUEUE_NAME = "unroute_queue";
    public static final String UNROUTE_EXCHANGE_NAME = "unroute_exchange";

    /**
     * 死信队列，这里将死信队列分为 1分钟，30分钟，2小时，不够的话在增加
     */
    public static final String DLX_ONE_MINUTES_QUEUE_NAME = "dlx_one_minutes_queue";
    public static final String DLX_ONE_MINUTES_EXCHANGE_NAME = "dlx_one_minutes_exchange";
    public static final String DLX_ONE_MINUTES_ROUTINGKEY_NAME = "dlx_one_minutes_routingkey";

    public static final String DLX_THIRTY_MINUTES_QUEUE_NAME = "dlx_thirty_minutes_queue";
    public static final String DLX_THIRTY_MINUTES_EXCHANGE_NAME = "dlx_thirty_minutes_exchange";
    public static final String DLX_THIRTY_MINUTES_ROUTINGKEY_NAME = "dlx_thirty_minutes_routingkey";

    public static final String DLX_TWO_HOURS_QUEUE_NAME = "dlx_two_hours_queue";
    public static final String DLX_TWO_HOURS_EXCHANGE_NAME = "dlx_two_hours_exchange";
    public static final String DLX_TWO_HOURS_ROUTINGKEY_NAME = "dlx_two_hours_routingkey";
}
