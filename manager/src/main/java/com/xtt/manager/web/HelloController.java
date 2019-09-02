package com.xtt.manager.web;

import com.alibaba.fastjson.JSON;
import com.xtt.common.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * @Author xuett
 * @Date 2019/8/28 15:59
 */
@RestController
public class HelloController {

    @Autowired
    private HelloService helloService;

    @RequestMapping("/hello")
    public String hello() {
        return helloService.hello();
    }

    @RequestMapping("/hello1")
    public String hello1(@RequestParam String name) {
        return helloService.hello1(name);
    }

    @RequestMapping("/hello2")
    public String hello2(@RequestHeader String name, @RequestHeader Integer age) {
        return JSON.toJSONString(helloService.hello2(name, age));
    }

    @RequestMapping("/hello3")
    public String hello1(@RequestBody User user) {
        return helloService.hello3(user);
    }

    @FeignClient("product-center")
    public interface HelloService {

        /**
         * hello
         *
         * @return
         */
        @RequestMapping("/hello")
        String hello();

        /**
         * hello1
         *
         * @param name
         * @return
         */
        @RequestMapping("/hello1")
        String hello1(@RequestParam String name);

        /**
         * hello2
         *
         * @param name
         * @param age
         * @return
         */
        @RequestMapping("/hello2")
        User hello2(@RequestHeader String name, @RequestHeader Integer age);

        /**
         * hello3
         *
         * @param user
         * @return
         */
        @RequestMapping("/hello3")
        String hello3(@RequestBody User user);
    }
}
