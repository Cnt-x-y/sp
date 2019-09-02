package com.xtt.manager.web;

import com.xtt.manager.service.HelloServiceFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author xuett
 * @Date 2019/8/28 15:59
 */
@RestController
public class HelloController {

    @Autowired
    private HelloServiceFeignClient helloServiceFeignClient;

    @RequestMapping("/hello")
    public String hello() {
        return helloServiceFeignClient.hello();
    }

}
