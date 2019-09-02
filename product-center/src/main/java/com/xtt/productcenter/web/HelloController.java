package com.xtt.productcenter.web;

import com.xtt.common.domain.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

/**
 * @Author xuett
 * @Date 2019/8/28 15:47
 */
@RestController
public class HelloController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    private DiscoveryClient client;

    @RequestMapping("/hello")
    public String hello() {
        return "Hello World";
    }

    @RequestMapping("/hello1")
    public String hello1(@RequestParam String name) {
        return String.format("hello %s", name);
    }

    @RequestMapping("/hello2")
    public User hello2(@RequestHeader String name, @RequestHeader Integer age) {
        return new User(name, age);
    }

    @RequestMapping("/hello3")
    public String hello3(@RequestBody User user) {
        return user.toString();
    }

}
