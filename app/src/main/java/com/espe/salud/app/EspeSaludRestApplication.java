package com.espe.salud.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {"com.espe.salud"})
@EnableJpaRepositories(basePackages = {"com.espe.salud.persistence"})
@EntityScan(basePackages = {"com.espe.salud.domain"})
@PropertySource("classpath:data.properties")
@EnableAspectJAutoProxy(proxyTargetClass = true)
@EnableJpaAuditing
public class EspeSaludRestApplication {
    public static void main(String[] args) {
        SpringApplication.run(EspeSaludRestApplication.class, args);
    }
}
