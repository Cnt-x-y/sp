package com.xtt.manager.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * @Author xuett
 * @Date 2019/9/4 17:56
 */
@Configuration
@Component
@ConfigurationProperties(prefix = "xtt")
@Data
public class XttBeanConfig {
    private String name;
}
