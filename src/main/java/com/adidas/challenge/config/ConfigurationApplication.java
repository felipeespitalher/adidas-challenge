package com.adidas.challenge.config;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import com.adidas.challenge.Constants;
import com.adidas.challenge.Properties;

@Configuration
@ComponentScan(basePackages = Constants.PACKAGE_BASE)
@EnableConfigurationProperties(Properties.class)
public class ConfigurationApplication {

  @Bean
  public RestTemplate restTemplate() {
    return new RestTemplate();
  }

}
