FROM anapsix/alpine-java
EXPOSE 8092
ADD build/libs/query-service-1.0.0.RELEASE.jar app.jar
ENTRYPOINT ["java","-jar","app.jar"]