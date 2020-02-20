package com.fms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;




@SpringBootApplication(scanBasePackages = {"com.fms.*"})  
@EnableJpaRepositories("com.fms.*")
@ComponentScan(basePackages = { "com.fms.*" })
@EntityScan("com.fms.*") 
@PropertySource({
	"classpath:mail.properties"
})
public class FmsAuthServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(FmsAuthServerApplication.class, args);
		
	}

}
