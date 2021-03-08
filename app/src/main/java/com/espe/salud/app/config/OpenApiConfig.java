package com.espe.salud.app.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Value("${application-version}")
    String apiVersion;
    @Value("${application-title}")
    String apiTitle;
    @Value("${application-description}")
    String apiDescription;
    @Value("${application-apiTermsOfServiceUrl}")
    String apiTermsOfServiceUrl;
    @Value("${application-apiLicense}")
    String apiLicense;
    @Value("${application-apiLicenseUrl}")
    String apiLicenseUrl;


    @Bean
    public OpenAPI springShopOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title(apiTitle)
                        .description(apiDescription)
                        .version(apiVersion)
                        .termsOfService(apiTermsOfServiceUrl)
                        .license(new License().name(apiLicense).url(apiLicenseUrl)));
    }
}
