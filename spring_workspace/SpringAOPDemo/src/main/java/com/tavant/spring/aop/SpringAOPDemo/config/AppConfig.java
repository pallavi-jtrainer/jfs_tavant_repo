package com.tavant.spring.aop.SpringAOPDemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import com.tavant.spring.aop.SpringAOPDemo.aspects.LoggingAspect;
import com.tavant.spring.aop.SpringAOPDemo.service.MyService;

@Configuration
@ComponentScan(value="com.tavant.spring.aop.SpringAOPDemo")
@EnableAspectJAutoProxy
public class AppConfig {
	
	@Bean
    public MyService myService() {
        return new MyService();
    }

    @Bean
    public LoggingAspect loggingAspect() {
        return new LoggingAspect();
    }
}
