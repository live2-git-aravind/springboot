package com.live;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.live.model.Product;

public class App {
	public static void main(String[] args) {
		//ProductRepository productRepository = null;
		// loading the spring ioc container (ApplicationContext)
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		// the bean is supplied by the Inversion of Control (IOC) container (i.e, the
		// ApplicationContext).

		Product product = context.getBean("product",Product.class);
		String productNameString = product.getProductName();
		//System.out.println(productNameString);
		context.close();
	}

}