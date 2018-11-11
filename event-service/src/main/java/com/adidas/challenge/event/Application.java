package com.adidas.challenge.event;

import com.adidas.challenge.common.config.Constants;
import com.adidas.challenge.common.config.Properties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@EnableConfigurationProperties(Properties.class)
@SpringBootApplication(scanBasePackages = {Constants.PACKAGE_BASE})
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
