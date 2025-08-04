package com.farouk.farouk.repository;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "com.exemple.demo")
public class CustomPropertises {
    private String apiUrl;
}
