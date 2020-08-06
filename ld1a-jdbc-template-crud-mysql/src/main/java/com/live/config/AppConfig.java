package com.live.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

//Indicates that a class declares one or more @Bean methods
//and may be processed by the Spring container
//to generate bean definitions
//and service requests for those beans at runtime
@Configuration
//Configures component scanning directives for use with @Configuration classes.
//Provides support parallel with Spring XML's <context:component-scan> element.
@ComponentScan("com.live")
//Annotation providing a convenient and declarative mechanism for adding a PropertySource to Spring's Environment. To be used inconjunction with @Configuration classes.
@PropertySource("classpath:database-mysql.properties")
public class AppConfig {

	private final String DB_DRIVER = "db_driver";	
	private final String DB_URL = "db_url";
	private final String DB_USER = "db_user";
	private final String DB_PASSWORD = "db_password";

	@Autowired
	//Interface representing the environment in which the current application is running.
	//Models two key aspects of the application environment: profiles and properties. 
	Environment environment;
	
	@Bean
	//A factory for connections to the physical data source that this DataSource object represents. 
	//An alternative to the DriverManager facility, a DataSource object is the preferred means of getting a connection.
	DataSource getDataSource() {
		//Simple implementation of the standard JDBC javax.sql.DataSource interface,configuring the plain old JDBC
		//java.sql.DriverManager via bean properties, and returning a new java.sql.Connection from every getConnection call.
		DriverManagerDataSource datasource = new DriverManagerDataSource();
		datasource.setDriverClassName(environment.getProperty(DB_DRIVER));
		datasource.setUrl(environment.getProperty(DB_URL));
		datasource.setUsername(environment.getProperty(DB_USER));
		datasource.setPassword(environment.getProperty(DB_PASSWORD));
		return datasource;
	}
}