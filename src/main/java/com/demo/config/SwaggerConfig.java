package com.demo.config;

import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

	@Bean
	public GroupedOpenApi publicApi() {
		return GroupedOpenApi.builder()
				.group("public-apis")
				.pathsToMatch("/**")
				.build();
	}

	@Bean
	public io.swagger.v3.oas.models.OpenAPI springShopOpenAPI() {
		return new io.swagger.v3.oas.models.OpenAPI()
				.info(new Info()
						.title("Spring Boot Demo API")
						.description("Spring Boot Demo API Documentation")
						.version("1.0.0"));
	}
}