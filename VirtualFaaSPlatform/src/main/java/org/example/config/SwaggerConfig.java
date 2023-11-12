/**
 * VirtualFaaSPlatform
 *
 * @Description: TODO
 * @Author: cherry
 * @Create on: 2023/11/8
 **/
package org.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@EnableOpenApi
public class SwaggerConfig {

    @Bean
    public Docket docket() {
        return new Docket(DocumentationType.OAS_30)
            .select()
            .paths(PathSelectors.any())
            .build()
            .apiInfo(
                new ApiInfoBuilder()
                    .contact(new Contact("HU", "http://localhost", "hu@mail.com"))
                    .title("VirtualFaaSPlatform")
                    .version("0.0.1")
                    .build()
            );
    }
}
