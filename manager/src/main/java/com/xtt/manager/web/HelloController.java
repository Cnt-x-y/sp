package com.xtt.manager.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @Author xuett
 * @Date 2019/8/28 15:59
 */
@RestController
public class HelloController {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/hello")
    public String hello() {
        ResponseEntity<String> responseEntity = restTemplate.getForEntity("http://PRODUCT-CENTER/hello", String.class);
        return responseEntity.getBody();
    }
}
