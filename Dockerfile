# build stage
FROM gradle:7.4.0-jdk17 AS builder

WORKDIR /app

COPY --chown=gradle:gradle . /app
RUN gradle clean build --no-daemon -x test

# RUN stage
FROM eclipse-temurin:17
EXPOSE 8080
RUN mkdir /app

# copy jar to working directory
COPY --from=builder /app/build/libs/sb-postgre-docker-0.0.1-SNAPSHOT.jar /app/sb-postgre-docker.jar

ENTRYPOINT ["java", "-jar", "/app/sb-postgre-docker.jar"]