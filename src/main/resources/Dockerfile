# First stage: build the application with Maven
FROM maven:3.8.1-jdk-13 AS build
WORKDIR /app
COPY pom.xml .
RUN mvn dependency:go-offline
COPY src ./src
RUN mvn package -DskipTests

# Second stage: create a lightweight production image
FROM openjdk:13-jdk-slim
WORKDIR /app
COPY --from=build /app/target/my-spring-boot-app.jar ./my-spring-boot-app.jar
ENTRYPOINT ["java", "-jar", "my-spring-boot-app.jar"]


