package com.example.test.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@RequiredArgsConstructor
public class OpenApiConfig {

    @Value("${gym.openapi.url}")
    private String url;

    @Value("${gym.openapi.description}")
    private String description;

    @Value("${gym.openapi.contact.name}")
    private String contactName;

    @Value("${gym.openapi.contact.email}")
    private String contactEmail;

    @Value("${gym.openapi.contact.url}")
    private String contactUrl;

    @Value("${gym.openapi.title}")
    private String title;

    @Value("${gym.openapi.version}")
    private String version;

    @Bean
    public OpenAPI customOpenAPI() {
        Server server = new Server();
        server.setUrl(url);
        server.setDescription(description);

        Contact contact = new Contact();
        contact.setName(contactName);
        contact.setEmail(contactEmail);
        contact.setUrl(contactUrl);

        Info info = new Info()
                .title(title)
                .version(version)
                .contact(contact)
                .description(description);

        return new OpenAPI()
                .info(info)
                .servers(List.of(server));
    }
}
