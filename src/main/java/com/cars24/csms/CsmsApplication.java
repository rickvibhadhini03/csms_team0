package com.cars24.csms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.cars24.csms")
public class CsmsApplication {

	public static void main(String[] args) {
		SpringApplication.run(CsmsApplication.class, args);
	}

}
