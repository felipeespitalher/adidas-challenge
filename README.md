# Adidas Challange Test - Felipe Passos

Solution for Adidas Coding Challenge

## Getting Started

## Environment Requirements 

* Gradle 4.x or newer
* Docker 17.x or newer
* Have Lombok plugin installed in your IDE to avoid seeing compile errors

## Setup Stream Server

[Landoop](https://github.com/Landoop/fast-data-dev) has a full docker image with Kafka and Zookeeper, including UI tools. Then we'll use to provide a stream server.

Create `landoop` docker-machine

```
$ docker-machine create --driver virtualbox --virtualbox-memory 4096 landoop
```

Run `docker-machine ls` to verify that the Docker Machine is running correctly. The command's output should be similar to:

```
$ docker-machine ls
NAME        ACTIVE   DRIVER       STATE     URL                         SWARM   DOCKER        ERRORS
landoop     *        virtualbox   Running   tcp://192.168.99.100:2376           v17.03.1-ce
```

Configure your terminal to be able to use the new Docker Machine named landoop:

```
$ eval $(docker-machine env landoop)
```

And run the Kafka Development Environment. Define ports, advertise the hostname and use extra parameters:

```
$ docker run --rm -p 2181:2181 -p 3030:3030 -p 8081-8083:8081-8083 \
       -p 9581-9585:9581-9585 -p 9092:9092 -e ADV_HOST=192.168.99.100 \
       landoop/fast-data-dev:latest
```

That's it. Visit http://192.168.99.100:3030 to get into the fast-data-dev environment

## Build

```
$ ./gradlew clean build
```

## Run

```
$ build && docker-compose up --build
```

## Documentation

### Swagger

Command Swagger `http://localhost:8090/swagger-ui.html`

Query Swagger `http://localhost:8092/swagger-ui.html`

### Example of use

Including itineraries

```
POST - http://localhost:8090/command/v1/city/list
HADER - Content-Type : application/json
BODY - [
         {
           "origin": "Lisbon",
           "destiny": "Porto",
           "departure": "2019-01-01T00:00:00+00:00",
           "arrival": "2019-01-01T00:00:00+00:00"
         }
       ]

```

Searching itineraries by cities

```
GET - http://localhost:8092/query/v1/itinerary/Lisbon/Paris
HADER - Content-Type : application/json
```
 
 
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
    