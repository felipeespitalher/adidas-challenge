# Adidas Challange Test - Felipe Passos

### Environment

* Java 1.8.x 
* Maven 3.3.x or newer
* Docker 17.x or newer

### Build and Run

```bash
$ mvn clean install && docker-compose up --build adidas-web
```

Swagger will be available at http://localhost:8080/swagger-ui.html

### Users for API

* adidas.normal / adidas123 -> for a normal user (cannot create and list users)
* adidas.super / adidas123 -> for a super user (can create new users and list them all)

### Notes

* Have Lombok plugin installed in your IDE to avoid seeing compile errors