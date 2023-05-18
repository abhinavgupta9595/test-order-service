package com.demo.testorderservice.config;

import java.util.Set;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.UiConfiguration;
import springfox.documentation.swagger.web.UiConfigurationBuilder;

@Configuration
@EnableOpenApi
@EnableWebMvc
public class SwaggerConfig implements WebMvcConfigurer{

	private static final String[] SUBMIT_METHODS = new String[]
			{"get", "post", "put", "delete", "patch", "head"};
	private static final String TITLE = "Order Service";
	private static final String DESCRIPTION = " Order Service to create Customer Orders and get Order Status";
	private static final String VERSION = "1.0.0";
	
	@Bean
	public UiConfiguration uiConfig() {
		return UiConfigurationBuilder.builder().validatorUrl(null).supportedSubmitMethods(SUBMIT_METHODS).build();
	}
	
	@Bean
	public Docket apiDocumentation() {
		return new Docket(DocumentationType.SWAGGER_2).enable(true).apiInfo(apiInfo()).select()
				.apis(RequestHandlerSelectors.any()).paths(PathSelectors.any()).build()
				.produces(Set.of(MediaType.APPLICATION_JSON_VALUE));
	}
	
	@Bean
	public ApiInfo apiInfo() {
		return new ApiInfoBuilder().title(TITLE).description(DESCRIPTION).version(VERSION).build();
	}
	
	@Override
	public void addResourceHandlers(final ResourceHandlerRegistry registry) {
		registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
		registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
	}
}
