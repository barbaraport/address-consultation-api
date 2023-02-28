package com.barbaraport.addressConsultationAPI.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


/**
 * this class is responsible for set up
 * Swagger for the API
 *
 * @author Port, B.
 */
@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

    /**
     * this method is the bean that returns the
     * configuration to Swagger work
     *
     * @return the configuration
     * @author Port, B.
     */
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage(
                        "com.barbaraport.addressConsultationAPI"))
                .paths(PathSelectors.any())
                .build();
    }
}
