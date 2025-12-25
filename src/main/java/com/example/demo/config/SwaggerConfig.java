package com.example.demo.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
    info = @Info(
        title = "Drug Interaction Checker API",
        version = "1.0",
        description = "Swagger for Drug Checker"
    )
)
public class SwaggerConfig {}
