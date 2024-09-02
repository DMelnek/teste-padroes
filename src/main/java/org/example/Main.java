package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Projeto Spring Boot gerado via Spring Initializer.
 * Os seguintes módulos foram selecionados:
 * - Spring Data JPA
 * - Spring Web
 * - H2 Database
 * - OpenFeign
 *
 * @author melnek
 */
@EnableFeignClients
@SpringBootApplication
@ComponentScan(basePackages = "consultas.gof")
@EnableJpaRepositories(basePackages = "consultas.gof.model")
@EntityScan(basePackages = "consultas.gof.model")
public class Main {

    public static void main(String[] args) {SpringApplication.run(Main.class, args);
    }
}