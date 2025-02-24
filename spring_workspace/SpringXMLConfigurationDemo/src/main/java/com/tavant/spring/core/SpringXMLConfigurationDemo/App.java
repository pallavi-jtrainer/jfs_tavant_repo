package com.tavant.spring.core.SpringXMLConfigurationDemo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tavant.spring.core.SpringXMLConfigurationDemo.entity.HelloWorld;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        
        HelloWorld obj = context.getBean("demo", HelloWorld.class);
        System.out.println(obj.getMessage());
        
    }
}
