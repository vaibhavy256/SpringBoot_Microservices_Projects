package com.example.inventory_service.config;

import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

public class MyConfig {
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
