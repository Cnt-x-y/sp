package com.xtt.manager.web;

import com.xtt.common.config.XttConfigBean;
import com.xtt.manager.service.HelloServiceFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author xuett
 * @Date 2019/8/28 15:59
 */
@RefreshScope
@RestController
public class HelloController {

    @Autowired
    private Environment environment;

    @Resource
    private HelloServiceFeignClient helloServiceFeignClient;

    @RequestMapping("/hello")
    public String hello() {
        return helloServiceFeignClient.hello() + ",name：" + environment.getProperty("xtt.name");
    }

    @RequestMapping("/hello1")
    public String hello1(@RequestParam String name) {
        return helloServiceFeignClient.hello1(name);
    }

}
