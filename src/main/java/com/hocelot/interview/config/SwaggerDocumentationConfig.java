package com.hocelot.interview.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;

import java.time.LocalDate;
import java.time.OffsetDateTime;

@Configuration
@EnableSwagger2WebMvc
public class SwaggerDocumentationConfig {

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
			.select()
			    .apis(RequestHandlerSelectors.withClassAnnotation(RestController.class))
				.paths(PathSelectors.any())
			.build()
			.directModelSubstitute(LocalDate.class, java.sql.Date.class)
			.directModelSubstitute(OffsetDateTime.class, java.util.Date.class)
			.apiInfo(apiInfo());
	}

	private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
            .title("API Service for Testing")
				.description("dsa45d6sa456d4sa65d46as54d56as456d4sa65")
				.version("v2-0")
            .contact(new Contact("Hocelot", "https://hocelot.com", "support@hocelot.com"))
            .build();
    }

}
