package com.dipak.awsnotesapi.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {

        return new OpenAPI()
                .info(new Info()
                        .title("AWS Notes API")
                        .version("1.0")
                        .description("Cloud-native Spring Boot REST API for AWS interview preparation")
                        .contact(new Contact()
                                .name("Dipak Ghosh")
                                .email("durja1008@gmail.com")
                        )
                );
    }
}