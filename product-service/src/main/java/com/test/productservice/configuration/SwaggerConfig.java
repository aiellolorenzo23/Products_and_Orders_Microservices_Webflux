package com.test.productservice.configuration;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI opOpenAPI(@Value("${spring.application.name}") String appName, @Value("${app.version}") String appVersion) {
        return new OpenAPI()
                .info(new Info().title(appName+" - Microservices Test - Spring Boot application")
                        .description("Products, a microservices test")
                        .version(appVersion)
                        .license(new License().name("springdoc-openapi v2.8.6 Wiki").url("https://springdoc.org/")))
                .externalDocs(new ExternalDocumentation()
                        .description("Products - Microservices Test")
                        .url("https://youtu.be/44cZCmtGoJM?si=No7SYCRiasGLJVt"));
    }
}
