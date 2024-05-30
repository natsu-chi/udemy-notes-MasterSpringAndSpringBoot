package com.chi.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.chi.learnspringframework.App02HelloWorldSpring;
import com.chi.learnspringframework.HelloWorldConfiguration;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		// SpringApplication.run(DemoApplication.class, args);
		
		new App02HelloWorldSpring();
		
	}

}
