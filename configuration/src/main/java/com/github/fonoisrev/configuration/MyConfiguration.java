package com.github.fonoisrev.configuration;

import com.github.fonoisrev.bean.Apple;
import com.github.fonoisrev.bean.Banana;
import org.springframework.asm.SpringAsmInfo;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfiguration {
    
    @Bean("apple")
    public Apple apple() {
        return new Apple();
    }
    
    @Bean
    public Banana banana() {
        return new Banana(apple2());// is the two apple the same?
    }
    
    @Bean("apple")
    public Apple apple2() {
        return new Apple();
    }
    
    @Bean
    public CommandLineRunner runner() {
        return new CommandLineRunner() {
            @Autowired
            Apple apple;
        
            @Autowired
            Banana banana;
        
            @Autowired
            BeanFactory factory;
            
            @Override
            public void run(String... args) throws Exception {
                boolean isSame = apple == banana.getApple();
                
                System.out.println("Apple == Banana.apple ? " + isSame);
            }
        };
    }
}
