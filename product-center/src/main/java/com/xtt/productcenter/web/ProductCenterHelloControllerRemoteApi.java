package com.xtt.productcenter.web;

import org.springframework.web.bind.annotation.RestController;

/**
 * @Author xuett
 * @Date 2019/8/28 15:47
 */
@RestController
public class ProductCenterHelloControllerRemoteApi implements HelloServiceRemoteApi {

    @Override
    public String hello() {
        return "hello,xttt";
    }

    @Override
    public String hello1(String name) {
        return "hello," + name;
    }
}
