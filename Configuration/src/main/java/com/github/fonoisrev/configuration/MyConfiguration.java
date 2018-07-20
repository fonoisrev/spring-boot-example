package com.github.fonoisrev.configuration;

import com.github.fonoisrev.bean.Apple;
import com.github.fonoisrev.bean.Banana;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfiguration {
    
    @Bean
    public Apple apple() {
        return new Apple();
    }
    
    @Bean
    public Banana banana() {
        return new Banana(apple());// is the two apple the same?
    }
    
    @Bean
    public CommandLineRunner runner() {
        return new CommandLineRunner() {
            @Autowired
            Apple apple;
        
            @Autowired
            Banana banana;
        
            @Override
            public void run(String... args) throws Exception {
                boolean isSame = apple == banana.getApple();
                System.out.println("Apple == Banana.apple ? " + isSame);
            }
        };
    }
}
