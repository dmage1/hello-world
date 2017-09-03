package com.example.myproject.domain;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(AppProperties.class)
public class MyConfiguration {
}
