FROM maven:3.9.6-eclipse-temurin-21 AS build

WORKDIR /maven

COPY pom.xml .
COPY src src

RUN mvn clean package

FROM openjdk:21-jdk

WORKDIR /be

COPY --from=build /maven/target/*.jar /be/javabackend.jar

CMD ["java", "-jar", "/be/javabackend.jar"]
