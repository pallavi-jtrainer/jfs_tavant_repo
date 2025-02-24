package com.tavant.spring.core.SpringXMLConfigurationDemo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tavant.spring.core.SpringXMLConfigurationDemo.entity.Course;
import com.tavant.spring.core.SpringXMLConfigurationDemo.entity.HelloWorld;
import com.tavant.spring.core.SpringXMLConfigurationDemo.entity.Student;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        
        HelloWorld obj = context.getBean("demo", HelloWorld.class);
        System.out.println(obj.getMessage());

//        Student s = context.getBean("student", Student.class);
//        
//        System.out.println("Student Name: " + s.getStudentName() + " " 
//        		+ "Course Name: " + s.getCourse().getCourseName());
        
    }
}
