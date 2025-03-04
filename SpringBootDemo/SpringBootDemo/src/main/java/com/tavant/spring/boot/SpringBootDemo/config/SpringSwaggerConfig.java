package com.tavant.spring.boot.SpringBootDemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class SpringSwaggerConfig {

	@Bean
	public OpenAPI apiInfo() {
	    Contact contact = new Contact();
	    contact.setEmail("sample@gmail.c");
	    contact.setName("Developer");

	    License mitLicense = new License().name("MIT License").url("https://choosealicense.com/licenses/mit/");

	    Info info = new Info()
	        .title("Books Management API")
	        .version("1.0")
	        .contact(contact)
	        .description("This API exposes endpoints to manage books.")
	        .license(mitLicense);

	    return new OpenAPI().info(info);
	  }
}
