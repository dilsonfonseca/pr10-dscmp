package br.com.projeto.integrado.springdoc;


import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.tags.Tag;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class SpringDocConfig {
    // http://localhost:8080/swagger-ui/index.html
    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Projeto integrado - API")
                        .version("v1")
                        .description("Implementação de queries personalizadas")
                        .contact(new Contact()
                                .name("Giovane Souza")
                                .email("developergiovanesouza@gmail.com"))
                        .license(new License()
                                .name("Apache 2.0")
                                .url("https:springdoc.org"))
                ).externalDocs(new ExternalDocumentation()
                        .description("Github (repositório do projeto):")
                        .url("link repositório")
                ).tags(
                        Arrays.asList(
                                new Tag().name("Projetos").description(""),
                                new Tag().name("Recursos").description(""),
                                new Tag().name("Tarefas").description(""),
                                new Tag().name("StatusTarefas").description(""),
                                new Tag().name("Usuários").description("")
                        )
                );
    }
}
