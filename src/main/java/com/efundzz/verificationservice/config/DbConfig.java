package com.efundzz.verificationservice.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"com.efundzz.dbconnect","com.efundzz.verificationservice"})
public class DbConfig {
}
