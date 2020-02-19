package com.fms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;


@SpringBootApplication

@ComponentScan("com.fms")
@PropertySource({
	"classpath:mail.properties"
})

public class FmsAuthServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(FmsAuthServerApplication.class, args);
		
	}

}
