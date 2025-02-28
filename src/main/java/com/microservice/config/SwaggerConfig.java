package com.microservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;

@Configuration
public class SwaggerConfig {
	
	@Bean
	public OpenAPI customeOpenAPI() {
		return new OpenAPI()
		.info(new io.swagger.v3.oas.models.info.Info().title("order-service").version("1.1"));
	}

}
