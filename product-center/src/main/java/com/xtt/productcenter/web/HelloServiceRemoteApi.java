package com.xtt.productcenter.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Author xuett
 * @Date 2019/9/2 11:17
 */
@RequestMapping("/refactor")
public interface HelloServiceRemoteApi {

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
}
