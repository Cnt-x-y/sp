package com.xtt.manager.web;

import com.xtt.manager.config.RabbitMqConstant;
import com.xtt.manager.config.RabbitMqProducer;
import com.xtt.manager.config.XttBeanConfig;
import com.xtt.manager.service.HelloServiceFeignClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 消息总线会刷新两种类中的配置属性
 *
 * 1.{@link RefreshScope}注解的类
 * 2.{@link ConfigurationProperties}注解的类
 *
 * @Author xuett
 * @Date 2019/8/28 15:59
 */
@RefreshScope
@RestController
public class HelloController {

    @Autowired
    private XttBeanConfig xttBeanConfig;

    @Value("${xtt.name}")
    private String name;

    @Resource
    private HelloServiceFeignClient helloServiceFeignClient;

    @Autowired
    private RabbitMqProducer rabbitMqProducer;

    @RequestMapping("/hello")
    public String hello() {
        return helloServiceFeignClient.hello() + ",name：" + xttBeanConfig.getName() + ",name:"  +name;
    }

    @RequestMapping("/hello1")
    public String hello1(@RequestParam String name) {
        return helloServiceFeignClient.hello1(name);
    }

    @RequestMapping("/send")
    public String send(@RequestParam String name) {
        rabbitMqProducer.send(RabbitMqConstant.UNROUTE_EXCHANGE_NAME, null, name);
        return name;
    }

}
