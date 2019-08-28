package com.xtt.productcenter.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author xuett
 * @Date 2019/8/28 15:47
 */
@RestController
public class HelloController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    private DiscoveryClient client;

    @RequestMapping("/hello")
    public String hello(){
        return "Hello World";
    }
}
