package com.adidas.challenge.query.configuration;

import com.adidas.challenge.common.config.Constants;
import org.neo4j.ogm.session.SessionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;
import org.springframework.data.neo4j.transaction.Neo4jTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@ComponentScan(basePackages = Constants.PACKAGE_BASE)
@EnableNeo4jRepositories(basePackages = Constants.PACKAGE_BASE)
public class Neo4jConfiguration {

    @Value("${neo4j.ogm.URI}")
    private String neo4jURL;

    @Value("${neo4j.ogm.username}")
    private String neo4jUsername;

    @Value("${neo4j.ogm.password}")
    private String neo4jPassword;

    @Bean
    public SessionFactory sessionFactory() {
        return new SessionFactory(configuration(), Constants.PACKAGE_BASE);
    }

    @Bean
    public org.neo4j.ogm.config.Configuration configuration() {
        org.neo4j.ogm.config.Configuration configuration = new org.neo4j.ogm.config.Configuration();
        configuration.set("neo4j.ogm.driver", "org.neo4j.ogm.drivers.bolt.driver.BoltDriver");
        configuration.set("neo4j.ogm.URI", neo4jURL);
        configuration.set("neo4j.ogm.username", neo4jUsername);
        configuration.set("neo4j.ogm.password", neo4jPassword);
        return configuration;
    }

    @Bean
    public Neo4jTransactionManager transactionManager() {
        return new Neo4jTransactionManager(sessionFactory());
    }

}
