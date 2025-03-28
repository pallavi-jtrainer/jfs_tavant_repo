package com.tavant.spring.aop.SpringAOPDemo.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
	@Around("execution(* com.tavant.spring.aop.SpringAOPDemo.service.MyService.performTask(..))")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();

        Object proceed = joinPoint.proceed();

        long executionTime = System.currentTimeMillis() - start;

        System.out.println(joinPoint.getSignature() + " executed in " + executionTime + "ms");
        return proceed;
    }
	
	@Before("execution(* com.tavant.spring.aop.SpringAOPDemo.service.MyService.placeOrder(..))")
    public void logBefore() {
        System.out.println("Logging before the order is placed...");
    }
	
	@After("execution(* com.tavant.spring.aop.SpringAOPDemo.service.MyService.shareProfile(..))")
	public void logAfter() {
		System.out.println("Logging after profile was shared");
	}
}
