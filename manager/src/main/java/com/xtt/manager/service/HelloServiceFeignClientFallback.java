package com.xtt.manager.service;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author xuett
 * @Date 2019/9/2 11:57
 */
@Component
@RequestMapping("/hello_fallback")
public class HelloServiceFeignClientFallback implements HelloServiceFeignClient{

    @Override
    public String hello() {
        return "hello方法，熔断";
    }

    @Override
    public String hello1(String name) {
        return null;
    }
}
