# Adidas Challenge Test - Felipe Passos

Solution for Adidas Coding Challenge

## Environment Requirements 

* Docker 17.x or newer
* Have Lombok plugin installed in your IDE to avoid seeing compile errors

## Run & Build

```
$ docker-compose up --build
```

## Access 

##### Kafka

    http://192.168.99.100:3030/

##### Neo4j

    http://localhost:7474/browser/
    
    username: neo4j
    passwork: adidas
    
##### Swagger

Command Service
 
    http://localhost:8090/swagger-ui.html
    
Query Service
 
    http://localhost:8092/swagger-ui.html
 
 ## Libs

##### Kafka
    It's is used for building real-time data pipelines and streaming apps. 
    The app uses Kafka to sends events between Command service and Processor service.
#### Spring Boot Dependencies
    It's third part library from Spring suite tools to manager spring dependencies.
##### Spring Cloud Stream
    It's a is a framework for building highly scalable event-driven microservices connected 
    with shared messaging systems.
##### Spring Boot Web Starter
    Starter for building web, including RESTful, applications using Spring. Uses Tomcat as the default embedded container
##### Spring Boot Actuator    
    It's is a sub-project of Spring Boot. It adds several production grade services to your application with little effort on your part. 
    In this guide, you’ll build an application and then see how to add these services.
#### Neo4j
    It's a graph database used to keep the data in way to run the Breadth First Search algorithm.
##### Swagger
    It's an open source tools to deliver APIs 
##### Lombok
    It's provides a great reduce of Java Boilerplate generating getters/setters, 
    constructor methods and builders. 
    
    
# NOTES

If yout local network has any proxy configuration, please update `gradle.properties`
