FROM anapsix/alpine-java
EXPOSE 8080
ADD build/libs/processor-service-1.0.0.RELEASE.jar app.jar
ENTRYPOINT ["java","-jar","app.jar"]