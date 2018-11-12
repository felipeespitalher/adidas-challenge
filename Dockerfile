#Build stage
FROM gradle:jdk10 as builder

COPY --chown=gradle:gradle . .
RUN gradle build

#Runtime stage
FROM openjdk:8-jre-alpine

EXPOSE 8080

COPY --from=builder /home/gradle/command-service/build/libs/*.jar /app/command-service.jar
COPY --from=builder /home/gradle/processor-service/build/libs/*.jar /app/processor-service.jar
COPY --from=builder /home/gradle/query-service/build/libs/*.jar /app/query-service.jar

# CMD and ENTRYPOINT should not be set as part of this image,
# Instead set it on container startup the desired service.