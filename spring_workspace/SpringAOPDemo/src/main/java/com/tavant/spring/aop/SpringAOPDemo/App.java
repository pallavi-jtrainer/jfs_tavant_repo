package com.tavant.spring.aop.SpringAOPDemo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.tavant.spring.aop.SpringAOPDemo.config.AppConfig;
import com.tavant.spring.aop.SpringAOPDemo.service.MyService;

public class App {
    public static void main(String[] args) {
    	ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
    	MyService service = context.getBean(MyService.class);
    	
//    	service.performTask();
//    	service.placeOrder();
    	service.shareProfile();
    }
}
