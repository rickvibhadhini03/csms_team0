package com.cars24.csms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//it does 3 work
//1.configuration--
//2.EnableAutoConfiguration----springboot appln directly enables mongodb like things
//3.ComponentScan

public class CsmsApplication {

	public static void main(String[] args) {
		SpringApplication.run(CsmsApplication.class, args);
	}

}
