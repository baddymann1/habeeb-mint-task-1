package com.mint.task1.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.function.Predicate;

import static springfox.documentation.builders.PathSelectors.any;
import static springfox.documentation.builders.PathSelectors.regex;

/**
 * @author Badmus Habeeb
 * @since 01/12/2020
 */
@RequiredArgsConstructor
@EnableSwagger2
@Configuration
public class SwaggerConfig {


    @Bean
    public Docket api() {

        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("task1")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.mint.task1.domain")).paths(any()).build()
                .apiInfo(buildApiInfo());
    }

    private ApiInfo buildApiInfo() {
        return new ApiInfoBuilder()
                .title("Task 1 API")
                .description("This API gives access to the Task1 API.")
                .version("0.0.1")
                .termsOfServiceUrl("https://www.google.com/terms")
                .contact(
                        new Contact(
                                "Task 1",
                                "https://www.google.com",
                                "foobar(at)google.com"
                        )
                )
                .license("Apache 2.0")
                .licenseUrl("https://www.google.com/license")
                .build();
    }
}

