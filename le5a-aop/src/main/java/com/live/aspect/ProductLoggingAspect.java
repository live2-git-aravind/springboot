package com.live.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class ProductLoggingAspect {
//-- join point : method execution
//-- pointcut expression : "execution(public String getProductName())"
//-- advice : before
	@Before("execution(public String getProductName())")
	public void getProductNameBeforeAdvice() {
		System.out.println("This is called before the execution of getProductName() method of Product class.");
	}
	@After("execution(public String getProductName())")
	public void getProductNameAfterAdvice() {
		System.out.println("This is called after the execution of getProductName() method of Product class.");
	}
}
