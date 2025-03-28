package com.tavant.hibernate.HibernateCachingDemo;

import com.tavant.hibernate.HibernateCachingDemo.entity.Users;
import com.tavant.hibernate.HibernateCachingDemo.services.UsersService;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        UsersService service = new UsersService();
        service.createUser(new Users("Prithvi", "Raj", "prithvi@jjajja.c"));
        
        System.out.println("First Level Caching --");
        service.firstLevelCachingDemo();
        
        System.out.println("Second Level Caching --");
        service.secondLevelCacheDemo();
    }
}
