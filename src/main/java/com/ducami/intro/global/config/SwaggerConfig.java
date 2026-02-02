package com.ducami.intro.global.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("동아리 소개 API")
                        .description("교육 봉사 동아리 웹사이트 백엔드 API 문서")
                        .version("1.0.0"))
                .servers(List.of(
                        new Server()
                                .url("https://wilily-noncrystallized-deb.ngrok-free.dev")
                                .description("개발 서버 (ngrok)")
                ));
    }
}