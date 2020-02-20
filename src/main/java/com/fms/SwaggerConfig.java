package com.fms;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
	 @Bean
	    public Docket productApi() {
	       return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.any()).build().apiInfo(apiInfo());
	    }
	    
	    private ApiInfo apiInfo() {
	    	return ApiInfo.DEFAULT;
	    	//return new ApiInfo("Feed Back Management REST API", "Feed Back Management REST API", 
	    	//		"1.0", "", new Contact("Jijo Mathew", "www.example.com", "jijo.mathew@cognizant.com"), "", "");
	    /*    return new ApiInfo(
	          "Feed Back Management REST API", 
	          "Feed Back Management REST API", 
	          "API ", 
	          "Terms of service", 
	          new Contact("Jijo Mathew", "www.example.com", "jijo.mathew@cognizant.com"), 
	          "License of API", "API license URL", Collections.emptyList());
	          */
	    }
}
