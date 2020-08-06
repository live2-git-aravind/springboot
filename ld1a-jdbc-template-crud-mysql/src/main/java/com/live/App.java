package com.live;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.live.config.AppConfig;
import com.live.model.Product;
import com.live.repository.ProductRepository;

public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "SPRING JDBC TEMPLATE");
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        ProductRepository productRepository = applicationContext.getBean(ProductRepository.class);
        List<Product> products = productRepository.getProducts();
        products.forEach(System.out::println);
        Product productbyid = productRepository.getProductById(2);
        System.out.println("Select Query by productid\n" +productbyid);
        productRepository.createProduct(new Product(3,"Spring JDBC",72.00f));
        System.out.println("Records After adding New Product");
        products=productRepository.getProducts();
        products.forEach(System.out::println);
		
		 productRepository.updateProduct(new Product(3,"Spring JDBC",90.00f));
		 System.out.println("Records After updating the project");
	        products=productRepository.getProducts();
	        products.forEach(System.out::println);
		 boolean status=productRepository.deleteProduct(3); 
		 if(status=true) {
		 System.out.println("Record Deleted"); 
		 }
		 System.out.println("Final Products after delete");
		 products=productRepository.getProducts();
		 products.forEach(System.out::println);
		 
    }
}