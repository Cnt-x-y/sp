package com.xtt.manager.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @Author xuett
 * @Date 2019/8/28 15:59
 */
@RestController
public class HelloController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private DiscoveryClient client;

    @RequestMapping("/hello")
    public String hello() {
        System.out.println("-------------------分割线---------------------");
        List<String> services = client.getServices();
        services.stream().forEach(serviceId -> {
            List<ServiceInstance> instances = client.getInstances(serviceId);
            instances.stream().forEach(instance -> {
                System.out.println(String.format("serviceId = %s host = %s port = %s uri = %s",
                        instance.getServiceId(), instance.getHost(), instance.getPort(), instance.getUri()));
            });
        });
        ResponseEntity<String> responseEntity = restTemplate.getForEntity("http://PRODUCT-CENTER/hello", String.class);
        return responseEntity.getBody();
    }
}
