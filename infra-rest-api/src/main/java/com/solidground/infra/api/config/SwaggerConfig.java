package com.solidground.infra.api.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

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

	@Value("${swagger.api.info.enabled}")
	private boolean swaggerApiInfoEnabled;

	@Value("${swagger.api.info.title}")
	private String title;

	@Value("${swagger.api.info.description}")
	private String description;

	@Value("${swagger.api.info.version}")
	private String version;

	@Value("${swagger.api.info.terms_of_service_url}")
	private String termsOfServiceUrl;

	@Value("${swagger.api.info.contact.name}")
	private String contactName;

	@Value("${swagger.api.info.contact.url}")
	private String contactUrl;

	@Value("${swagger.api.info.contact.email}")
	private String contactEmail;

	@Value("${swagger.api.info.license.name}")
	private String licenseName;

	@Value("${swagger.api.info.license.url}")
	private String licenseUrl;

	@Bean
	public Docket producApi() {
		Docket productApi = new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage(this.swaggerDocumentationBase))
				.paths(regex(this.swaggerApiBase))
				.build();

		if (this.swaggerApiInfoEnabled) {
			productApi = productApi.apiInfo(this.metaInfo());
		}

		return productApi;
	}

	@Bean
	public ApiInfo metaInfo() {
		return new ApiInfo(
				this.title,
				this.description,
				this.version,
				this.termsOfServiceUrl,
				new Contact(this.contactName, this.contactUrl, this.contactEmail),
				this.licenseName,
				this.licenseUrl, Collections.emptyList());
	}
}
