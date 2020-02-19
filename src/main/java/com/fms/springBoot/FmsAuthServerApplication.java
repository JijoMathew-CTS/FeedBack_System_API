package com.fms.springBoot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication

@ComponentScan("com.fms.springBoot")

public class FmsAuthServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(FmsAuthServerApplication.class, args);
		
	}

}
