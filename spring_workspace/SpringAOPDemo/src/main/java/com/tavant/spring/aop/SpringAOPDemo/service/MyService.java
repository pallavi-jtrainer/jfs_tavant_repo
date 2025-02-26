package com.tavant.spring.aop.SpringAOPDemo.service;

import org.springframework.stereotype.Service;

@Service
public class MyService {

	public void performTask() {
        System.out.println("Performing task...");
        // Simulate a time-consuming task
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Task completed.");
    }
	
	public void placeOrder() {
        System.out.println("Order is being placed...");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Order placed successfully.");
	}
	
	public void shareProfile() {

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Profile shared successfully.");
	}
    
}
