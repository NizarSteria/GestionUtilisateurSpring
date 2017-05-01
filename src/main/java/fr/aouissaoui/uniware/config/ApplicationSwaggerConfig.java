package fr.aouissaoui.uniware.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Java config for Springfox swagger documentation plugin
 * <p>
 * Created by nizaraouissaoui on 01/05/2017.
 */


@Configuration
@EnableSwagger2
@ComponentScan(basePackages = "fr.aouissaoui.uniware.web.rest")
public class ApplicationSwaggerConfig {

    @Bean
    public Docket customDocket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build()
                .apiInfo(getApiInfo());
    }

    private ApiInfo getApiInfo() {
        return new ApiInfo(
                "REST Users management backend Api Documentation",
                "This is REST API documentation of the Spring users backend",
                "1.0",
                "User backend terms of service",
                new Contact(
                        "Nizar Aouissaoui",
                        "https://github.com/NizarSteria/GestionUtilisateurSpring.git",
                        "aouissaoui.nizar@gmail.com"),
                "",
                "h");
    }


}

