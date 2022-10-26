package com.example.demo.config;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author wangyujie
 */
@Component
@ConfigurationProperties("swagger")
@Data
public class SwaggerProperties {

    private Boolean enable;

    private String applicationName;

    private String applicationVersion;

    private String applicationDescription;

    private String tryHost;
}