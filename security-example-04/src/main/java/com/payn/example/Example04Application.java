package com.payn.example;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import static org.springframework.boot.SpringApplication.run;

@ComponentScan(basePackages = "com.payn.example")
@SpringBootApplication
public class Example04Application {
	public static void main(String[] args) {
		ConfigurableApplicationContext run = run(Example04Application.class, args);
	}
}
