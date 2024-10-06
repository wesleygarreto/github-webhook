package com.garreto.githubwebhook.configuration;

import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import io.swagger.v3.oas.models.OpenAPI;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("GitHub Issues and Contributors API")
                        .version("1.0")
                        .description("API para buscar issues e contribuidores de repositórios GitHub"));
    }
}
