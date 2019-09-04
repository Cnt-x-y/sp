package com.xtt.productcenter.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author xuett
 * @Date 2019/8/28 15:47
 */
@RestController
public class ProductCenterHelloControllerRemoteApi implements HelloServiceRemoteApi {

    @Autowired
    private Environment environment;

    @Override
    public String hello() {
        return "hello," + environment.getProperty("xtt.name");
    }

    @Override
    public String hello1(String name) {
        return "hello," + name;
    }
}
