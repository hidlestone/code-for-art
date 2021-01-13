package com.payn.example;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import static org.springframework.boot.SpringApplication.run;

@ComponentScan(basePackages = "com.payn.example")
@SpringBootApplication
public class Application {
	public static void main(String[] args) {
		ConfigurableApplicationContext run = run(Application.class, args);
	}
}
