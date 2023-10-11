package com.efundzz.verificationservice.config;

import feign.jackson.JacksonDecoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignConfig {
    @Bean
    public JacksonDecoder feignDecoder() {
        return new JacksonDecoder();
    }
}
