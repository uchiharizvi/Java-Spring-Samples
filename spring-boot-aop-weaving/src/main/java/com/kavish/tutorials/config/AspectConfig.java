package com.kavish.tutorials.config;

import com.kavish.tutorials.aspects.LogResponseTimeAspect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
public class AspectConfig {
//    @Bean
//    public LogResponseTimeAspect logResponseTimeAspect(){
//        return new LogResponseTimeAspect();
//    }
}
