package com.adidas.challenge.common.config;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.ObjectVendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@Configuration
@EnableSwagger2
@AllArgsConstructor
public class SwaggerConfiguration {

    private final Properties properties;

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2).select()
                .apis(RequestHandlerSelectors.basePackage(Constants.PACKAGE_BASE))
                .paths(PathSelectors.any()).build().apiInfo(getApiInfo());
    }

    private ApiInfo getApiInfo() {
        return new ApiInfo(properties.getApi().getName(), properties.getApi().getDescription(),
                properties.getApi().getVersion(), properties.getApi().getTermsOfServiceUrl(), getContact(),
                properties.getApi().getLicense(), properties.getApi().getLicenseUrl(),
                Collections.singletonList(vendors()));
    }

    private ObjectVendorExtension vendors() {
        return new ObjectVendorExtension(properties.getApi().getMaintainer().getName());
    }

    private Contact getContact() {
        String name = properties.getApi().getMaintainer().getName();
        String email = properties.getApi().getMaintainer().getEmail();
        return new Contact(name, "", email);
    }

}
