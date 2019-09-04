package com.xtt.common.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * @Author xuett
 * @Date 2019/9/4 10:55
 */
@Configuration
@Component
@ConfigurationProperties(prefix = "xtt")
@Data
public class XttConfigBean {

    private String name;
}
