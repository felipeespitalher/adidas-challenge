FROM anapsix/alpine-java
COPY target/adidas-1.0.0.jar app.jar
EXPOSE 8080
CMD ["java","-jar","app.jar"]