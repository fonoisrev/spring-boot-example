package com.github.fonoisrev.binding;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(MyProperties.class)
public class MyConfiguration {
    
    @Autowired
    MyProperties myProperties;
    
    @Bean
    public String name() {
        return myProperties.getFirstName();
    }
    
}
