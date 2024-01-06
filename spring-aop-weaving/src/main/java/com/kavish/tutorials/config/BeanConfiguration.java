package com.kavish.tutorials.config;

import com.kavish.tutorials.aspect.LogResponseTimeAspect;
import com.kavish.tutorials.service.PaymentsService;
import com.kavish.tutorials.service.PaymentsServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.web.client.RestTemplate;

@Configuration
@ComponentScan(basePackages = "com.kavish.tutorials.aspect")
@EnableAspectJAutoProxy
public class BeanConfiguration {
    @Bean
    public LogResponseTimeAspect restLogAspect(){
        return new LogResponseTimeAspect();
    }
    @Bean
    public PaymentsService paymentsService(){
        return new PaymentsServiceImpl(restTemplate());
    }
    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
