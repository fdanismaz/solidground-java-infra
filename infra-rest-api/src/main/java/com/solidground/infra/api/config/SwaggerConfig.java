package com.solidground.infra.api.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.builders.PathSelectors.regex;

/**
 * @author furkand
 * 1/2/2019 3:54 PM
 */
@Configuration
@EnableSwagger2
@PropertySource("restapi.properties")
public class SwaggerConfig {

	@Value("${swagger.doc.base}")
	private String swaggerDocumentationBase;

	@Value("${swagger.api.base}")
	private String swaggerApiBase;

	@Bean
	public Docket producApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage(this.swaggerDocumentationBase))
				.paths(regex(this.swaggerApiBase))
				.build();

	}
}
