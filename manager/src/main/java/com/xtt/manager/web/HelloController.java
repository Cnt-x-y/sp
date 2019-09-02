package com.xtt.manager.web;

import com.xtt.manager.service.HelloServiceFeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author xuett
 * @Date 2019/8/28 15:59
 */
@RestController
public class HelloController {

    @Resource
    private HelloServiceFeignClient helloServiceFeignClient;

    @RequestMapping("/hello")
    public String hello() {
        return helloServiceFeignClient.hello();
    }

    @RequestMapping("/hello1")
    public String hello1(@RequestParam String name){
        return helloServiceFeignClient.hello1(name);
    }

}
